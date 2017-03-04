<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!-- =========================================================================================== -->
<!-- BEGIN HEADER -->
<head>

	
	
	<spring:url value="/webjars/jquery/2.1.4/dist/jquery.js"                                var="jqueryJs" />
	<spring:url value="/webjars/jquery-ui/1.12.0/jquery-ui.js"                              var="jqueryUiJs" />
	<spring:url value="/webjars/bootstrap/3.3.6/js/bootstrap.js"                            var="bootstrapJs" />
	<spring:url value="/webjars/bootstrap/3.3.6/css/bootstrap.css"                          var="bootstrapCss" />
	<spring:url value="/webjars/jquery-ui/1.12.0/jquery-ui.css"                             var="jqueryUiCss" />
	<spring:url value="/webjars/datatables/1.10.12/media/js/jquery.dataTables.min.js"       var="datatableJs" />
	<spring:url value="/webjars/datatables/1.10.12/media/js/dataTables.bootstrap.min.js"    var="datatableBootstrapJs" />
	<spring:url value="/webjars/datatables/1.10.12/media/css/dataTables.bootstrap.min.css"  var="datatableCss" />
	<spring:url value="/js/bootstrap-validator-0.11.5.min.js"                               var="bootstrapValidatorJs" />
	
	
	<%-- Angular --%>
	<spring:url value="/webjars/angularjs/1.5.3/angular.js"                                 var="angularJs" />
	<spring:url value="/webjars/angularjs/1.5.3/i18n/angular-locale_it-it.js"               var="angularLocaleItJs" />
	<spring:url value="/webjars/angularjs/1.5.3/angular-route.js"               		    var="angularRouteJs" />
	<spring:url value="/webjars/angular-ui-bootstrap/0.9.0/ui-bootstrap-tpls.js"            var="uiAngularTlpsJs" />
	
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge" charset="UTF-8">
    
    <title>${titoloApplicazione}</title>
    
    <head>
    
        <script src="${jqueryJs}"></script>
        <script src="${bootstrapJs}"></script>   
       	<script src="${jqueryUiJs}"></script>
       	<script src="${datatableJs}"></script>
        <script src="${datatableBootstrapJs}"></script>
        <script src="${bootstrapValidatorJs}"></script>
        
        <%-- Angular --%>
        <script src="${angularJs}"></script>
        <script src="${angularLocaleItJs}"></script>
        <script src="${angularRouteJs}"></script>
        <script src="${uiAngularTlpsJs}"></script>
        
       	<link rel="stylesheet" href="${datatableCss}">  
        <link rel="stylesheet" href="${bootstrapCss}">  
        <link rel="stylesheet" href="${jqueryUiCss}">  
        
        
    </head>
      
    <meta name="viewport" content="width=device-width">
    
	
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->	
	
	<%-- 
	<%@ include file="/WEB-INF/css/commonCss.jsp"%>
	<%@ include file="/WEB-INF/js/commonJs.jsp"%>
	--%>
	 
</head>

<!-- END HEADER -->
<!-- =========================================================================================== -->
	