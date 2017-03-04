
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%-- 
OGGETTO JSON COMUNE

{
    "istatComune":"107002",
    "istatProvincia":
    {
        "codProvincia":"107","abiIstatRegione":
        {
            "codRegione":"020","denominazione":"SARDEGNA","ripartizioneGeografica":"ISOLE"
        },
        "denominazione":"Carbonia-Iglesias",
        "sigla":"CI"
    },
    "codComune":" 002 ",
    "denominazione":"Calasetta",
    "codCatastale":"B383"
}






--%>

<!-- BEGIN manageClienteJavascript -->
<script>
	$(document).ready(
	function() {
	
		console.log('Test autocomplete');


		$("#term").autocomplete({
			source: '${contextPath}/test/testAutocomplete'
        });

		$("#denominazione").autocomplete({
			source: function(request, response) {
				    $.ajax({
							url: "${contextPath}/test/findIstatComuneByDenominazione",
							type: "GET",
							data: { term: request.term },
							dataType: "json",
							success: function(data) {
								console.log("success");
		                    	response($.map(data, function(v,i){
		                    	    return {
		                    	    	label: v.denominazione,
		                    	        value: v.denominazione
		                    	   };
		                    	}));
		                    }
				    });
			}   
        });

		
		
	});
</script>
<!-- END manageClienteJavascript -->






