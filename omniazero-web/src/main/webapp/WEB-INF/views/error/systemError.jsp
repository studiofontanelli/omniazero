<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- =========================================================================================== -->
<!-- =========================================================================================== -->
<!-- BEGIN PAGINA -->

<div class="alert alert-danger">
	<strong>Si e' verificato un errore!</strong> 
	
	<c:if test="${not empty ERRROR_MESSAGE}">
		${ERRROR_MESSAGE}
	</c:if>
	
	
</div>
<!-- END PAGINA -->
<!-- =========================================================================================== -->