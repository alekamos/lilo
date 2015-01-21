<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="/LiLo/js/jquery-1.11.2.min.js"></script>
<!-- import -->


<script type="text/javascript" src="/LiLo/Personaljs/scriptComuni.js"></script>
<link href="/LiLo/bootstrap/css/bootstrap.min.css" rel="stylesheet"	media="screen">
<script src="/LiLo/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/LiLo/include/jquery-ui-1.9.2.custom/css/ui-darkness/jquery-ui-1.9.2.custom.css">
<script type="text/javascript" src="/LiLo/include/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js"></script>


<title><tiles:insertAttribute name="title" /></title>
</head>

<body>



	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="menu" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />


</body>
</html>