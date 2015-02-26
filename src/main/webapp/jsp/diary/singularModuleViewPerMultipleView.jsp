<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="col-md-6">

<h1 class="upper-case"><strong>
	<c:out value="${moduleExtended.moduleType.name}" /></strong>
</h1>

<c:if test="${moduleExtended.moduleHeader.idModule != null}">
	<s:label cssClass="control-label" value="idModuleHeader" />
	<c:out value="${moduleExtended.moduleHeader.idModule}" />
	<br />
</c:if>

<c:if test="${moduleExtended.moduleHeader.idModuleType != null}">
	<s:label cssClass="control-label" value="id ModuleType" />
	<c:out value="${moduleExtended.moduleHeader.idModuleType}" />
	<br />
</c:if>

<c:if test="${moduleExtended.moduleHeader.insertTimestamp != null}">
	<s:label cssClass="control-label" value="insert" />
	<fmt:formatDate pattern="d/M/yy HH:mm:ss"
		value="${moduleExtended.moduleHeader.insertTimestamp}" />
	<br />
</c:if>

<c:if test="${moduleExtended.moduleHeader.updateTimestamp != null}">
	<s:label cssClass="control-label" value="update"/>
	<fmt:formatDate pattern="d/M/yy HH:mm:ss"
		value="${moduleExtended.moduleHeader.updateTimestamp}" />
</c:if>

<br />

<c:if
	test="${(moduleExtended.moduleType.textContent1Name != null && moduleExtended.moduleType.textContent1Name != '') || (moduleExtended.moduleType.textContent2Name != null && moduleExtended.moduleType.textContent2Name != '') || (moduleExtended.moduleType.textContent3Name != null && moduleExtended.moduleType.textContent3Name != '')}">
<!-- 	<h3>Module text</h3> -->
	<c:if test="${moduleExtended.moduleType.textContent1Name != null}">

		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.textContent1Name}"/></h3>
		<c:out value="${moduleExtended.moduleText.text1Value}"/>
		
	</c:if>
	<br />
	<c:if test="${moduleExtended.moduleType.textContent2Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.textContent2Name}" /></h3>
		<c:out value="${moduleExtended.moduleText.text2Value}"></c:out>
	</c:if>
	<br />
	<c:if test="${moduleExtended.moduleType.textContent3Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.textContent3Name}" /></h3>
		<c:out value="${moduleExtended.moduleText.text3Value}"></c:out>
	</c:if>
	<br />
</c:if>

<c:if
	test="${(moduleExtended.moduleType.numericDataContent1Name != null && moduleExtended.moduleType.numericDataContent1Name != '') || (moduleExtended.moduleType.numericDataContent2Name != null && moduleExtended.moduleType.numericDataContent2Name != '') || (moduleExtended.moduleType.numericDataContent3Name != null && moduleExtended.moduleType.numericDataContent3Name != '')}">
<!-- 	<h3>Module Numeric</h3> -->
	<c:if
		test="${moduleExtended.moduleType.numericDataContent1Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.numericDataContent1Name}" /></h3>
		<c:out value="${moduleExtended.moduleNumeric.numericData1Value}"></c:out>
	</c:if>
	<br />
	<c:if
		test="${moduleExtended.moduleType.numericDataContent2Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.numericDataContent2Name}" /></h3>
		<c:out value="${moduleExtended.moduleNumeric.numericData2Value}"></c:out>
	</c:if>
	<br />
	<c:if
		test="${moduleExtended.moduleType.numericDataContent3Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.numericDataContent3Name}" /></h3>
		<c:out value="${moduleExtended.moduleNumeric.numericData3Value}"></c:out>
	</c:if>
	<br />
</c:if>

<c:if
	test="${(moduleExtended.moduleType.datetimeContent1Name != null && moduleExtended.moduleType.datetimeContent1Name != '') || (moduleExtended.moduleType.datetimeContent2Name != null && moduleExtended.moduleType.datetimeContent2Name != '') || (moduleExtended.moduleType.datetimeContent3Name != null && moduleExtended.moduleType.datetimeContent3Name != '')}">
<!-- 	<h3>Module Datetime</h3> -->
	<c:if test="${moduleExtended.moduleType.datetimeContent1Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.datetimeContent1Name}" /></h3>

		<c:choose>
			<c:when
				test="${moduleExtended.moduleType.datetimeContent1Type == 'DATE'}">
				<c:set var="formatDatetimeContent1" value="EEEE d MMMM yyyy" />
			</c:when>
			<c:when
				test="${moduleExtended.moduleType.datetimeContent1Type == 'TIME'}">
				<c:set var="formatDatetimeContent1" value="HH:mm:ss" />
			</c:when>

			<c:when
				test="${moduleExtended.moduleType.datetimeContent1Type == 'DATETIME'}">
				<c:set var="formatDatetimeContent1"
					value="EEEE d MMMM yyyy HH:mm:ss" />
			</c:when>
		</c:choose>
		<fmt:formatDate
			value="${moduleExtended.moduleDatetime.datetime1Value}"
			pattern="${formatDatetimeContent1}" />
	</c:if>
	<br />

	<c:if test="${moduleExtended.moduleType.datetimeContent2Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.datetimeContent2Name}" /></h3>

		<c:choose>
			<c:when
				test="${moduleExtended.moduleType.datetimeContent2Type == 'DATE'}">
				<c:set var="formatDatetimeContent2" value="EEEE d MMMM yyyy" />
			</c:when>
			<c:when
				test="${moduleExtended.moduleType.datetimeContent2Type == 'TIME'}">
				<c:set var="formatDatetimeContent2" value="HH:mm:ss" />
			</c:when>

			<c:when
				test="${moduleExtended.moduleType.datetimeContent2Type == 'DATETIME'}">
				<c:set var="formatDatetimeContent2"
					value="EEEE d MMMM yyyy HH:mm:ss" />
			</c:when>
		</c:choose>
		<fmt:formatDate
			value="${moduleExtended.moduleDatetime.datetime2Value}"
			pattern="${formatDatetimeContent2}" />
	</c:if>
	<br />

	<c:if test="${moduleExtended.moduleType.datetimeContent3Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.datetimeContent3Name}" /></h3>

		<c:choose>
			<c:when
				test="${moduleExtended.moduleType.datetimeContent3Type == 'DATE'}">
				<c:set var="formatDatetimeContent3" value="EEEE d MMMM yyyy" />
			</c:when>
			<c:when
				test="${moduleExtended.moduleType.datetimeContent3Type == 'TIME'}">
				<c:set var="formatDatetimeContent3" value="HH:mm:ss" />
			</c:when>

			<c:when
				test="${moduleExtended.moduleType.datetimeContent3Type == 'DATETIME'}">
				<c:set var="formatDatetimeContent3"
					value="EEEE d MMMM yyyy HH:mm:ss" />
			</c:when>
		</c:choose>
		<fmt:formatDate
			value="${moduleExtended.moduleDatetime.datetime3Value}"
			pattern="${formatDatetimeContent3}" />
	</c:if>
	<br />
</c:if>
</div>

