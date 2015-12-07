<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="http://www.amcharts.com/lib/3/amcharts.js"></script>
<script src="http://www.amcharts.com/lib/3/serial.js"></script>
<script src="http://www.amcharts.com/lib/3/themes/light.js"></script>
<script type="text/javascript" src="Personaljs/scriptChartDivHisto.js"></script>



<div class="container-fluid" id="dayNavigatorDiv">


	<h2>Advanced search result</h2>
	<table class="table">
		<thead>
			<tr>
				<td>field</td>
				<td>value</td>
			<tr>
		</thead>
		<tbody>
			<tr>
			<tr>
				<td>Start date</td>
				<td><fmt:formatDate value="${moduleFinder.startDateDt}" pattern="dd/MM/yyy" /></td>
			</tr>
			<tr>
				<td>End date</td>
				<td><fmt:formatDate value="${moduleFinder.endDateDt}" pattern="dd/MM/yyy" /></td>
			</tr>
			<tr>
				<td>Contain text</td>
				<td><c:out value="${moduleFinder.containedText}" /></td>
			</tr>
			<tr>
				<td>id Module type</td>
				<td><c:out value="${moduleFinder.idModuleType}" /></td>
			</tr>
		</tbody>
	</table>




	<c:choose>
		<c:when test="${navigatorElementList eq null}"><h2>No results found</h2></c:when>

		<c:when test="${navigatorElementList ne null}"><h2>Result table:</h2>
		<br>
			<br>



			<div class="col-md-10 text-center col-md-offset-1">
				<c:forEach items="${navigatorElementList}" var="element" varStatus="idx">
					<c:set var="link" value="viewModule?moduleFinder.idModuleCluster=${element.idModuleCluster}" />
					<c:choose>
						<c:when test="${element.idModuleCluster != null && element.idModuleCluster != 0}">
							<a type="button" class="btn btn-primary" href="${link}"><fmt:formatDate value="${element.dateDay}"
									pattern="E dd/MM/yy" /></a>
						</c:when>
						<c:when test="${element.idModuleCluster == 0 || element.idModuleCluster == null}">
							<a type="button" class="btn btn-default"><fmt:formatDate value="${element.dateDay}" pattern="E dd/MM/yy" /></a>
						</c:when>
					</c:choose>
					<c:if test="${idx.count % 7 == 0}"><br></c:if>
				</c:forEach>
				
			</div>
			
			

		</c:when>
	</c:choose>
	
<div class="col-md-12">	
<h2>Result distribution:</h2>
<jsp:include page="/jsp/stat/histoChartPage.jsp" />
</div>

</div>



