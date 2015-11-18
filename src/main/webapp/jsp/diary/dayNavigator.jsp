<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:formatDate value="${navigatorElementList[1].dateDay}" pattern="yyyyMMdd" var="startDate" />
<fmt:formatDate value="${navigatorElementList[14].dateDay}" pattern="yyyyMMdd" var="endDate" />

<div class="container-fluid" id="dayNavigatorDiv">

	<div class="row">
		<div class="col-md-1 text-center">
			<a type="button" class="btn btn-default"
				onclick="ajaxCall('getNavigatorAjax?moduleFinder.endDate=${startDate}','dayNavigatorDiv')"> <span
				class="glyphicon glyphicon-circle-arrow-left"></span>
			</a>
		</div>


		<div class="col-md-10 text-center">
			<div class="btn-group">
				<c:forEach items="${navigatorElementList}" var="element" varStatus="idx">
					<c:set var="link" value="viewModule?moduleFinder.idModuleCluster=${element.idModuleCluster}" />
					<c:choose>
						<c:when test="${element.idModuleCluster != null && element.idModuleCluster != 0}">
							<c:choose>
								<c:when test="${idx.count==8}">
									<a type="button" class="btn btn-danger" href="${link}"><fmt:formatDate value="${element.dateDay}"
											pattern="dd/MM" /></a>
								</c:when>
								<c:otherwise>
									<a type="button" class="btn btn-primary" href="${link}"><fmt:formatDate value="${element.dateDay}"
											pattern="dd/MM"/></a>
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="${element.idModuleCluster == 0 || element.idModuleCluster == null}">
							<a type="button" class="btn btn-default"><fmt:formatDate value="${element.dateDay}"
									pattern="dd/MM" /></a>
						</c:when>
					</c:choose>
				</c:forEach>
			</div>
		</div>


		<div class="col-md-1 text-center">
			<a type="button" class="btn btn-default"
				onclick="ajaxCall('getNavigatorAjax?moduleFinder.startDate=${endDate}','dayNavigatorDiv')"><span
				class="glyphicon glyphicon-circle-arrow-right"></span></a>

		</div>
	</div>



</div>