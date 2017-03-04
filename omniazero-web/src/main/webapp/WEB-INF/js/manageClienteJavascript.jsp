
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- BEGIN manageClienteJavascript -->
<script>

	angular.module('demoManageCliente', [])
		.controller("ManageClienteController", ["$scope", function($scope) {
			$scope.changeText = function() {
				$scope.myText = "Ciao Cliente!";
			};
			$scope.cosaSei = function() {
				$scope.myText = "Una recchia";
			};
		}])
		.controller("DemoRecchiaController", ["$scope", "$log", function($scope, $log) {
			$scope.changeText = function() {
				var message= "Sei una recchia";
				$scope.myText = message;
	
				console.log("ciao " + message);
				$log.debug("$log " + message);
			};
		}])
	;





	$(document).ready(



	function() {
	
		console.log('Ci siamo');

		//var delay = $("#istatComune").autocomplete( "option", "delay" );
		//console.log('delay= ' + delay);

		$("#istatComuneJQuery").autocomplete({
			delay: 500, 
			minLength: 2,
			source: function(request, response) {
					console.log("term= " + request.term);
			    	$.ajax({
							cache: true,
							url: "${contextPath}/findIstatComuneByDenominazione",
							type: "GET",
							data: { term: request.term },
							dataType: "json",
							success: function(data) {
								console.log("successeee...item... data= " + JSON.stringify(data));
		                    	response($.map(data, function(item, i){
		                    		//console.log("response OK");
		                    		//console.log("i = "  +i);
		                    	    return {
			                    	    label: item.denominazione + item.istatComune,
		                    	        value: item.denominazione,
		                    	    	istat: item.istatComune 
		                    	   };
		                    	}));
		                    }, 
		                    complete: function (){
								console.log("complete");	
							} 
				    });
			},
			select: function (event, ui) {
				console.log("select");
	            //AutoCompleteSelectHandler(event, ui)
	            var item = ui.item;              
	            console.log("item= " + JSON.stringify(item));
    			$("#idIstatComuneJQuery").val(item.istat);
    			 console.log("idIstatComuneJQuery= " + $("#idIstatComuneJQuery").val(item.istat));
	 
	        },
			close: function( event, ui) {
				console.log("close");
				//console.log("event");
				//console.log("event to element" + JSON.stringify(event.ToElement));
				
    			
				/*
				for (var property in event) {
					console.log(property + "=" + event[property]);
				}
				console.log("ui");
				for (var property in ui) {
					console.log(property + "=" + ui[property]);
				}
				*/
			}
        });
	

		
		
	});
</script>
<!-- END manageClienteJavascript -->