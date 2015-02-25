<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" src="Personaljs/scriptComuni.js"></script>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="include/jquery-ui-1.9.2.custom/jquery-ui.css">
<script type="text/javascript"
	src="include/jquery-ui-1.9.2.custom/js/jquery-ui-1.9.2.custom.js"></script>
<link href="customCss/LiLo.css" rel="stylesheet">

<!-- google font -->
<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>


<title><tiles:insertAttribute name="title" /></title>
</head>

<body>

	<tiles:insertAttribute name="header" />

	<tiles:insertAttribute name="menu" />
	
	<tiles:insertAttribute name="form" />
	
	<tiles:insertAttribute name="navigator" />

	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />


</body>
</html>