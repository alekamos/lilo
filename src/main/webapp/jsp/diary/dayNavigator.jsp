<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<table class="table">
		<tr>
		<td><a href=""><span class="glyphicon glyphicon-circle-arrow-left"></span></a></td>
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
			<td><span class="glyphicon glyphicon-circle-arrow-right"></span></td>
		</tr>
	</table>