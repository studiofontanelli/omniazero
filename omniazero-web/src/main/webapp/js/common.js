$.notifyDefaults({
	type: 'info',
	allow_dismiss: true
});

//TODO spostare in file globale
function extractComposedAjaxResponseObject(html) {
	var output = {};
	var selector = "#ajaxDataPayloadContainer";
	var rendered = $(html);
	var jsonContainer = rendered.find(selector);
	if (jsonContainer.size() > 0) {
		var raw = jsonContainer.html();
		raw = $("<div/>").html(raw).text();
		output.data = $.parseJSON(raw);
	}
	else {
		output.data = null;
	}
	
	output.html = rendered.find("#ajaxHtmlContainer").html();
	return output;
}

/* TODO spostare in file globale
 * 
 * esegue una richiesta ajax, scompone il risultato e chiama i rispettivi
 * callback con l'html e i dati risultanti.
 * parametri di input:
 * - options: può essere un url testuale (default: 'GET' senza dati aggiuntivi)
 *		oppure un oggetto 'options' passato direttamente alla chiamata .ajax
 * - success: callback da chiamare in caso non ci siano errori http.
 *		al callback vengono passati i parametri 'html' e 'data' contenenti
 *		la risposta scompattata in html e dati deserializzati
 * - failed : callback da chiamare in caso ci siano errori html
 *		al callback viene passato il parametro di errore
 * - finalCallback: callback da chiamare in ogni caso, dopo eventuali
 *		altri callback. Al callback vengono passati i parametri
 *			in caso di successo: true, html, data
 *			in caso di errore http: false, error 
 *
 * siccome questo è javascript e javascript è terribile, gli ultimi tre parametri
 * sono opzionali
 *
 * snippet per copia-incolla:
	 ajaxComposed("${contextPath}/URLDACHIAMARE",
		function(html, data) {
			// richiesta http completata con successo
		},
		function(error) {
			// errore http
		},
		function(success) {
			// alla fine, in ogni caso
		}
	);
 
 * esempio di utilizzo:
	 ajaxComposed('http://url-da-chiamare-in-get', function(html, data){
		 if (data.successo) {
			$("#modal").html(html).modal('show');
		 }
		 else {
			 alert("errore lato server: " + data.errore);
	 	 }
	}, function(e) {
		alert("errore nella chiamata ajax: " + e);
	}, function(success) {
		console.log("chiamata terminata. flag successo: " + success);
	})
	
	oppure, per opzioni aggiuntive:

	ajaxComposed({
		url : 'http://url-da-chiamare-in-get',
		type: 'POST',
		data : dati_da_postare
	}, function(html, data){
		if (data.successo) {
			$("#modal").html(html).modal('show');
		}
		else {
			alert("errore lato server: " + data.errore);
	 	}
	}, function(e) {
		alert("errore nella chiamata ajax: " + e);
	})
 */
function ajaxComposed(options, success, failed, finalCallback) {
	if (typeof options == "string") options = {url : options};
	if (!options.dataType) options.dataType = "html";
	if (!options.type) options.type = "GET";

	console.groupCollapsed("[AJAX] avvio chiamata ajax a " + options.url);
	console.log('url: ', options.url);
	console.log('options: ', options);
	console.groupEnd();

	var reqInfo = options;
	
	return $.ajax(options)
	.done(function(rawHtml) {
		var response = extractComposedAjaxResponseObject(rawHtml);

		if (response.data.error) {
			var e = buildErrorFromAjaxOkButFail(response);
			console.error("errore in richiesta ajax composta", e.message);

			console.groupCollapsed("[AJAX] errore server-side nella chiamata ajax a " + options.url);
			console.log('error: ', e);
			console.log('r.options: ', reqInfo);
			console.groupEnd();
			
			if (failed) failed(e);
			if (finalCallback) finalCallback(false, e, response.html, response.data);
		}
		else {
			console.groupCollapsed("[AJAX] fine chiamata ajax a " + options.url);
			console.log('data: ', response.data);
			console.log('html: ', 'log dump html non abilitato');
			console.log('r.options: ', reqInfo);
			console.groupEnd();
			
			if (success) success(response.html, response.data);
			if (finalCallback) finalCallback(true, null, response.html, response.data);
		}
	})
	.fail(function(jqXHR, textStatus, errorThrown) {
		var e = buildErrorFromAjaxFail(jqXHR, textStatus, errorThrown);
		
		console.error("errore in richiesta ajax composta", e.message);

		console.groupCollapsed("[AJAX] errore http nella chiamata ajax a " + options.url);
		console.log('error: ', e);
		console.log('r.options: ', reqInfo);
		console.groupEnd();
		
		if (failed) failed(e, e.htmlResponse, e.dataResponse);
		if (finalCallback) finalCallback(false, e, e.htmlResponse, e.dataResponse);
	});
}

function customValidationApplyElementFail(element, message) {
	var parentContainer = element.parent();
	if (!parentContainer.hasClass("has-error")) {
		parentContainer.addClass("has-error");
		parentContainer.append("<div class='gen-error'><font color='#a94442'>" + message + "</font></div>");
	}

	element.on("change keydown", function(e) {
		var parentContainer = $(this).parent();
		parentContainer.removeClass("has-error");
		parentContainer.find(".gen-error").remove();
	});
} 

function customValidationApplyRule(element, rule, panel) {
	var value = element.val();
	var msg = null;

	if (!$.isArray(rule)) {
		rule = [rule];
	}

	$.each(rule, function(valIndex, validatorInstance) {
		if (typeof validatorInstance == "function") {
			msg = validatorInstance(value, element, panel);
		}
		else if (typeof validatorInstance == "string") {
			msg = (customValidators[validatorInstance])(value, element, panel);
		}
		else {
			console.error("tipo validatore non definito: " + (typeof validatorInstance));
		}
		if (typeof msg == "string") return false;
	});

	if (typeof msg == "string") return msg;
	return null;
}

function customFormAttributeDrivenValidation(targetContainerSelector) {

	var panel = $(targetContainerSelector);
	if (!panel.size()) {
		console.log("attenzione: richiesta validazione custom di contenitore non trovato: " + targetContainerSelector);
		return true;
	}

	var errors = 0;

	var elements = panel.find("[x-validate]");
	elements.each(function(i, e){
		e = $(e);
		var rule = e.attr("x-validate").split(" ");
		if (!rule) {
			return;
		}

		var msg = customValidationApplyRule(e, rule, panel);

		if (msg) {
			errors ++;
			customValidationApplyElementFail(e, msg);
		}
	});

	if (errors) {
		console.log("errori trovati durante validazione custom di " + targetContainerSelector);
		return false;
	}
	
	return true;
};
 
function customFormValidation(targetContainerSelector, validationRules) {

	var panel = $(targetContainerSelector);
	if (!panel.size()) {
		console.log("attenzione: richiesta validazione custom di contenitore non trovato: " + targetContainerSelector);
		return true;
	}

	var errors = 0;

	$.each(validationRules, function(selector, rule) {
		if (!rule) rule = [VALIDATOR_NOT_NULL];
		
		var elements = panel.find(selector);
		
		elements.each(function(i, element) {
			element = $(element);
			var msg = customValidationApplyRule(element, rule, panel);

			if (msg) {
				errors ++;
				customValidationApplyElementFail(element, msg);
			}
		});
	});

	if (errors) {
		console.log("errori trovati durante validazione custom di " + targetContainerSelector);
		return false;
	}
	
	return true;
}

/* @BOOKMARK:VALIDATORS */
var VALIDATOR_NOT_NULL = "not-null";
var VALIDATOR_NUMERIC = "numeric";
var VALIDATOR_DATE = "date";

var customValidators = {
	"not-null" : function(value) {
		if (value === null || value === undefined || value === "") return "campo obbligatorio";
		return true;
	},
	"numeric" : function(value) {
		if (!$.isNumeric(value)) return "inserire un valore numerico";
		return true;
	},
	"date" : function(value) {
		if (value === null || value === undefined || value === "") return true;
		if (!_isValidDate(value)) return "inserire una data valida nel formato dd/mm/YYYY";
		return true;
	}
};

function _isValidDate(dateStr) {

    var datePat = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
    var matchArray = dateStr.match(datePat);

    if (matchArray == null) {
        return false;
    }

    day = matchArray[1];
    month = matchArray[3];
    year = matchArray[5];

    if (month < 1 || month > 12) {
        return false;
    }

    if (day < 1 || day > 31) {
        return false;
    }

    if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
        return false;
    }

    if (month == 2) {
        var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
        if (day > 29 || (day == 29 && !isleap)) {
            return false;
        }
    }
    return true;
}

var CookieManager = {

	defaultNamespace : "scadeweb",

	switchNamespace : function(namespace) {
		CookieManager.defaultNamespace = namespace; 
	},
	
	set : function(name, value, days) {
		var expires;

	    if (days) {
	        var date = new Date();
	        date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
	        expires = "; expires=" + date.toGMTString();
	    } else {
	        expires = "";
	    }
	    
	    document.cookie = encodeURIComponent(CookieManager.defaultNamespace + "." + name) + "=" + encodeURIComponent(JSON.stringify(value)) + expires + "; path=/";
	},

	get : function(name) {
	    var nameEQ = encodeURIComponent(CookieManager.defaultNamespace + "." + name) + "=";
	    var ca = document.cookie.split(';');
	    for (var i = 0; i < ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0) === ' ') c = c.substring(1, c.length);
	        if (c.indexOf(nameEQ) === 0) return JSON.parse(decodeURIComponent(c.substring(nameEQ.length, c.length)));
	    }
	    return null;
	},

	del : function(name) {
		CookieManager.set(name, "", -1);
	}
};

var ERROR_TYPE_UNKNOWN = 0;
var ERROR_TYPE_HTTP = 1;
var ERROR_TYPE_SERVER = 2;
var ERROR_TYPE_LOCAL = 3;

function buildErrorFromAjaxOkButFail(parsed) {
	var e = {
		status : 500,
		message : parsed.data.error,
		exception : parsed.data.exception,
		type : ERROR_TYPE_SERVER,
		aborted : false,
		htmlResponse : parsed.html,
		dataResponse : parsed.data
	};

	return e;
}

function buildErrorFromAjaxFail(r, textStatus, errorThrown) {
	/*
	*  The function receives three arguments: 
		> The jqXHR (in jQuery 1.4.x, XMLHttpRequest) object, 
		> a string describing the type of error that occurred
			Possible values for the second argument (besides null) are 
			"timeout", "error", "abort", and "parsererror". 
		> and an optional exception object, if one occurred. 
			When an HTTP error occurs, errorThrown receives the textual portion of the HTTP status, 
			such as "Not Found" or "Internal Server Error."
	*/
	var e = {
		status : 500,
		message : "errore imprevisto",
		exception : null,
		type : ERROR_TYPE_UNKNOWN,
		aborted : false,
		htmlResponse : null,
		dataResponse : null
	};
	
	if (textStatus == "timeout") {
		e.message = "La richiesta al server non ha ricevuto risposta.";
		e.type = ERROR_TYPE_HTTP;
	}
	else if (textStatus == "abort") {
		e.message = "La richiesta al server e' stata annullata dall'utente.";
		e.type = ERROR_TYPE_HTTP;
		e.aborted = true;
	} 
	else if (textStatus == "parsererror") {
		e.message = "Il server ha risposto con un formato non valido.";
		e.type = ERROR_TYPE_HTTP;
	} 
	else if (textStatus == "error") {
		e.message = "Errore nella richiesta: " + errorThrown;
		e.type = ERROR_TYPE_HTTP;
	} 
	else {
		e.message = "Il server ha risposto con un codice di errore: " + errorThrown;
		e.type = ERROR_TYPE_HTTP;
	}

	if (r.responseText.indexOf("ajaxContainer") >= 0) {
		var parsed = extractComposedAjaxResponseObject(r.responseText);
		if (parsed.data && parsed.data.errorType == "server") {
			e.message = parsed.data.error;
			e.exception = parsed.data.exception;
			e.type = ERROR_TYPE_SERVER;
			e.htmlResponse = parsed.html; 
			e.dataResponse = parsed.data;
		}
	}
	
	if (r.status >= 100) {
		e.status = r.status;
	}

	return e;
}
