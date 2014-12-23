<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>



<h1>Module view</h1>

<h3>Module dayHost</h3>
<c:out value="${moduleExtended.moduleDayHost.dateDayHost}"></c:out>


<h3>Module Header</h3>
<c:out value="${moduleExtended.moduleHeader.idModule}"></c:out>

<h3>Module text</h3>
<c:out value="${moduleExtended.moduleText.text1Value}"></c:out>


