<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="container-fluid">

	<c:forEach items="${moduleExtendedList}" var="moduleExtended"
		varStatus="idx">
		<c:set var="moduleExtended" scope="request" value="${moduleExtended}" />

		<c:choose>
			<c:when test="${idx.count==1}">
				<c:if test="${idx.count==1}">
					<h1 class="date-title">
						<fmt:formatDate pattern="EEEE d MMMM yyyy"
							value="${moduleExtended.moduleDayHost.dateDayHost}" />
					</h1>
				</c:if>

			</c:when>
			<c:otherwise>
				<jsp:include page="singularModuleViewPerMultipleView.jsp" /></c:otherwise>
		</c:choose>





	</c:forEach>
</div>


