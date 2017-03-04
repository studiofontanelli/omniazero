<!-- =========================================================================================== -->
<!-- =========================================================================================== -->
<!-- BEGIN Manage Cliente -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />








<div id="formContents" ng-app="demoManageCliente">

	<form:form 
		id="mainContactsForm"
		method="post" 
		action="${contextPath}/saveCliente"
		modelAttribute="mainContactsForm" 
		class="form-horizontal" 
		>
		
		
		
<div ng-controller="ManageClienteController" class="row" >
	<legend> Cliente </legend>

	<div class="col-md-6">
		<div class="form-group error">
			<form:label class="control-label col-lg-2"
				style="text-allign: left;" path="mainContacts.nome"> 
						Nome  *
			</form:label>
			<div class="col-lg-6">
				<form:input path="mainContacts.nome" class="form-control"
					maxlength="100" placeholder="Nome" id="titolo"
					/>
				<form:hidden path="mainContacts.id"/>
			</div>
		</div>

		<div class="form-group error">
			<form:label class="control-label col-lg-2 "
				style="text-allign: left;" path="mainContacts.cognome"> 
						Cognome  *<form:errors path="mainContacts.cognome" />
			</form:label>
			<div class="col-lg-6">
				<form:input path="mainContacts.cognome" class="form-control"
					maxlength="100" placeholder="Cognome" id="titolo"
					 />
			</div>
		</div>
	</div>



	<div class=" col-md-6">


		<div class="form-group error">
			<form:label class="control-label col-lg-2 "
				style="text-allign: left;" path="mainContacts.email"> 
						Email  *<form:errors path="mainContacts.email" />
			</form:label>
			<div class="col-lg-6">
				<form:input path="mainContacts.email" class="form-control"
					maxlength="100" placeholder="Cognome" id="titolo"
					 />
			</div>
		</div>
		
		<div class="form-group error">
			<form:label class="control-label col-lg-2 "
				style="text-allign: left;" path="mainContacts.note"> 
						note<form:errors path="mainContacts.note" />
			</form:label>
			<div class="col-lg-6">
				<form:checkboxes items="${webFrameworkList}" path="mainContacts.note" /> 		
			</div>
		</div>
		
		<div class="form-group error">
			<form:label class="control-label col-lg-2 "
				style="text-allign: left;" path="mainContacts.istatComune"> 
						Comune (JQuery) *<form:errors path="mainContacts.email" />
			</form:label>
			<div class="col-lg-6">
				<form:input path="mainContacts.istatComune.denominazione" class="form-control" maxlength="100" placeholder="comune" id="istatComuneJQuery"/>
				<form:hidden path="mainContacts.istatComune.istatComune" class="form-control" id="idIstatComuneJQuery" />
				
			</div> 
			
		</div>
		
		
		
		<div class="form-group error">
			<form:label class="control-label col-lg-2 "
				style="text-allign: left;" path="mainContacts.istatComune"> 
						Comune (Angular)  * {{ istatComuneAngular }}<form:errors path="mainContacts.email" />
			</form:label>
			<div class="col-lg-6">
				<input type="text" ng-model="istatComuneAngular"  class="form-control" maxlength="100" placeholder="comune" id="istatComuneAngular"/>
				
			</div> 
			
			
			
		</div>
		
		
	</div>
	
	<div class=" col-md-6">
		<form:button id="salva" class="btn btn-primary" ng-click="changeText()">  
		   <span class="glyphicon glyphicon-paperclip"></span>
				Salva
		</form:button>
		
		
		
	</div>

	</form:form>
</div>

 


</div>

<!-- END  Manage Cliente -->
<!-- =========================================================================================== -->