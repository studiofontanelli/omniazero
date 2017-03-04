<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@page session="true"%>

<div class="ajaxContainer">
	<c:if test="${not empty ajaxDataPayload }">
		<div id="ajaxDataPayloadContainer" style="display:none;">
			<c:out value="${ajaxDataPayload}" />
		</div>
	</c:if>
	<div id="ajaxHtmlContainer">
		<tiles:insertAttribute name="body" />
	</div>
</div>
