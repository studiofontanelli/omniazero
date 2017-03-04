<!-- =========================================================================================== -->
<!-- =========================================================================================== -->
<!-- BEGIN test autocomplete -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div id="formContents">


<form:form method="get" action="">
    <h1>autocomplete</h1>
    Enter Name: <input id="term">  
    
    <h1>cerca comune</h1>
    Denominazione: <input id="denominazione">  
       
</form:form>   
	
	
</div>



</div>

<!-- END  -->
<!-- =========================================================================================== -->