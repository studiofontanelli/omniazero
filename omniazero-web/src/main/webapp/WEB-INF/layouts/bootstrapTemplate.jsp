<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<!DOCTYPE html>
<html>
<tiles:insertAttribute name="header" />

<body>
<div class="container">

	<tiles:insertAttribute name="title" ignore="true" />
	<tiles:insertAttribute name="navbar" />
	<tiles:insertAttribute name="errorMessage"  />
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="javascript" />
	<tiles:insertAttribute name="footer" ignore="true" />
	
</div>	
</body>

</html>


	