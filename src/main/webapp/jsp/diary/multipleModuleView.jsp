<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:forEach items="${moduleExtendedList}" var="moduleExtended">
	<c:set var="moduleExtended" scope="request" value="${moduleExtended}"/>
	<jsp:include page="singularModuleView.jsp" />
</c:forEach>


