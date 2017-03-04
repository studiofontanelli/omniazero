
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- =========================================================================================== -->

<br/><br/><br/><br/>

<c:if test="${not empty ERROR_MESSAGE}">
	
	<div class="alert alert-danger" role="alert">
		<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
  		<span class="sr-only">Error:</span>
		${ERROR_MESSAGE}
	</div>
</c:if>

<c:if test="${not empty INFO_MESSAGE}">
	
	<div class="alert alert-info">
		${INFO_MESSAGE}
	</div>
</c:if>



<!-- =========================================================================================== -->