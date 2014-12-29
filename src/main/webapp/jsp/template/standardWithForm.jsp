<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- import -->
<link rel="stylesheet" type="text/css"
	href="/LiLo/include/jquery-ui-1.9.2.custom/css/ui-darkness/jquery-ui-1.9.2.custom.css">
<script type="text/javascript"
	src="/LiLo//include/jquery-ui-1.9.2.custom/js/jquery-1.8.3.js"></script>
<script type="text/javascript"
	src="/LiLo//include/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js"></script>
<script type="text/javascript" src="/LiLo/js/scriptComuni.js"></script>


<title><tiles:insertAttribute name="title" /></title>

</head>
<body>

	<div id="header">
		<tiles:insertAttribute name="header" />
	</div>

	<div id="menuDiv">
		<tiles:insertAttribute name="menu" />
	</div>

	<div id="form">
		<tiles:insertAttribute name="form" />
	</div>

	<div id="body">
		<tiles:insertAttribute name="body" />
	</div>

	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>


</body>
</html>