<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container-fluid">

	<table class="table">
		<tr>
			<c:forEach items="${navigatorElementList}" var="element">
				<c:set var="link"
					value="viewModule?moduleFinder.idModuleCluster=${element.idModuleCluster}" />
				<td><c:choose>
						<c:when test="${element.idModuleCluster != 0}">
							<a href="${link}"><fmt:formatDate value="${element.dateDay}"
									pattern="yy/MM/dd" /></a>
						</c:when>
						<c:when test="${element.idModuleCluster == 0}">
							<fmt:formatDate value="${element.dateDay}" pattern="yy/MM/dd" />
						</c:when>
					</c:choose></td>
			</c:forEach>
		</tr>
	</table>


<c:forEach items="${moduleExtendedList}" var="moduleExtended" varStatus="idx">
	<c:set var="moduleExtended" scope="request" value="${moduleExtended}"/>
	
	<c:if test="${idx.count==1}">
	<h1 class="date-title"><fmt:formatDate pattern="EEEE d MMMM yyyy"
	value="${moduleExtended.moduleDayHost.dateDayHost}" /></h1>
	</c:if>
	
	<jsp:include page="singularModuleViewPerMultipleView.jsp" />
</c:forEach>
</div>


