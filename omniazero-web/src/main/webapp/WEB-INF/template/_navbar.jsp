<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<sec:authentication var="user" scope="page" property="principal" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <div class="navbar-brand">Omniazero</div>
          
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
           
             <c:if test="${user.currentProfilo != null}">
             	<li><a href="<%=request.getContextPath()%>/ng#/"><span class="glyphicon glyphicon-calendar"></span> Agenda</a></li>
				<c:if test="${user.currentProfilo.codice == 'PMO' }">
             		<li><a href="<%=request.getContextPath()%>/iniziativa/nuovaIniziativa"><span class="glyphicon glyphicon-plus"></span> Crea</a></li>
             	</c:if>
             	
            </c:if>
            <li><a href="${contextPath}/"><span class="glyphicon"></span>Home</a></li>
            <li><a href="${contextPath}/nuovoCliente"><span class="glyphicon glyphicon-plus"></span>Nuovo cliente</a></li>
            <li><a href="${contextPath}/elencoClienti"><span class="glyphicon"></span>Elenco clienti</a></li>
            <li><a href="${contextPath}/test/autocomplete"></span>Test autocomplete</a></li>
             <li><a href="${contextPath}/angular/home"></span>Angular</a></li>
            <!-- 
            <li>
            	<a id="containerNotificationTitle" style="cursor:pointer;">
            		<span class="glyphicon glyphicon-bell"></span>
            		Notifiche 
            		<span class="badge badge-notify"
            			id="notificationUnreadCounterBadge" 
            			style="background:red; position:relative; top: -14px; left: -13px; display:none;">
            		3
            		</span>
           		</a>
         	</li>
         	 -->
          </ul>
         
          
          <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
                        	<span class="glyphicon glyphicon-user"></span> 
                        		${user.nome} ${user.cognome} 
                        		<c:if test="${user.currentProfilo != null}">
                        			- ${user.currentProfilo.descrizione}
                        		</c:if>
                        		
                        	<span class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                        	
                        	<c:if test="${user.elencoProfili.size() > 1}">
                        		<!-- 
                        		<li><a href="${contextPath}/cambiaProfilo?redirect=${requestScope['javax.servlet.forward.request_uri']}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Cambia profilo</a></li>
                        		 -->
                        		 <c:if test="${user.currentProfilo != null}">
                        		 	<li><a href="${contextPath}/cambiaProfilo"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span> Cambia profilo</a></li>
                        		 </c:if>
                        	</c:if>
                            <li><a href="${contextPath}/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Logout</a></li>
                        </ul>
                    </li>
                </ul>
          
          
        </div><!--/.nav-collapse -->
      </div>
    </nav>
