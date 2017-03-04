<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@page session="true"%>

<!DOCTYPE html>
<html>
<tiles:insertAttribute name="header" />


<body>

<div class="container container-grey">
	
	<tiles:insertAttribute name="title" />
	<tiles:insertAttribute name="navbar" />
	<tiles:insertAttribute name="body" />
	
</div>

<tiles:insertAttribute name="footer"/>

</body>
</html>
	