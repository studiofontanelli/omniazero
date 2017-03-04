<!-- =========================================================================================== -->
<!-- =========================================================================================== -->
<!-- BEGIN Angular -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<script>
        angular.module('cloudconf', [])
			.controller("TestController", ["$scope", function($scope) {
				$scope.changeText = function() {
					$scope.myText = "Muahahaha!";
				};
				$scope.cosaSei = function() {
					$scope.myText = "Una recchia";
				};
			}])
			.controller("RecchiaController", ["$scope", "$log", function($scope, $log) {
				$scope.changeText = function() {
					var message= "Sei una recchia";
					$scope.myText = message;

					console.log("ciao " + message);
					$log.debug("$log " + message);
				};
			}])
		;
		</script>



<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div ng-app="cloudconf">

	<h1>Angular Example</h1>
	<h2>Data-binding</h2>
	<div ng-controller="TestController">
		<p>
			<input ng-model="myText" value="bar">
		</p>
		<p>
			I wrote: <strong>{{ myText }}</strong>
		</p>
		<p>
			<button ng-click="changeText()">Change now!</button>
			<button ng-click="cosaSei()">Cosa sei?</button>
		</p>
	</div>
	RECCHIA Controller
	<div ng-controller="RecchiaController">
		<p>
			<input ng-model="myText" value="bar">
		</p>
		<p>
			I wrote: <strong>{{ myText }}</strong>
		</p>
		<p>
			<button ng-click="changeText()">Change now!</button>

		</p>
	</div>

</div>

<!-- END  Angular -->
<!-- =========================================================================================== -->