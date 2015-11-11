<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container-fluid" id="dayNavigatorDiv">


<fmt:formatDate value="${navigatorElementList[1].dateDay}" pattern="yyyyMMdd" var="startDate" />
<fmt:formatDate value="${navigatorElementList[14].dateDay}" pattern="yyyyMMdd" var="endDate" />


	<table class="table">
		<tr>
			<td><a onclick="ajaxCall('getNavigatorAjax?moduleFinder.endDate=${startDate}','dayNavigatorDiv')" >
			<span class="glyphicon glyphicon-circle-arrow-left"></span></a></td>
			<c:forEach items="${navigatorElementList}" var="element" varStatus="idx">
				<c:set var="link" value="viewModule?moduleFinder.idModuleCluster=${element.idModuleCluster}" />
				<td><c:choose>
						<c:when test="${element.idModuleCluster != null && element.idModuleCluster != 0}">
							<a href="${link}" <c:if test="${idx.count==8}">style="border:solid 1px;"</c:if>  ><fmt:formatDate value="${element.dateDay}"
									pattern="dd/MM/yy" /></a>
						</c:when>
						<c:when test="${element.idModuleCluster == 0 || element.idModuleCluster == null}">
							<fmt:formatDate value="${element.dateDay}" pattern="dd/MM/yy" />
						</c:when>
					</c:choose></td>
			</c:forEach>
			<td><a onclick="ajaxCall('getNavigatorAjax?moduleFinder.startDate=${endDate}','dayNavigatorDiv')"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></td>
		</tr>
	</table>
</div>