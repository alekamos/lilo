<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<h1><c:out value="${moduleExtended.moduleType.name}"/></h1>

<h3>Module dayHost</h3>
<fmt:formatDate pattern="EEEE d MMMM yyyy"
	value="${moduleExtended.moduleDayHost.dateDayHost}" />

<br />
<br />
<h3>Module Header</h3>
<c:if test="${moduleExtended.moduleHeader.idModule != null}">
	<s:label value="idModuleHeader" />
	<c:out value="${moduleExtended.moduleHeader.idModule}" />
</c:if>
<br />
<c:if test="${moduleExtended.moduleHeader.idModuleType != null}">
	<s:label value="id ModuleType" />
	<c:out value="${moduleExtended.moduleHeader.idModuleType}" />
</c:if>
<br />
<c:if test="${moduleExtended.moduleHeader.insertTimestamp != null}">
	<s:label value="insert timestamp" />
	<fmt:formatDate pattern="EEEE d MMMM yyyy HH:mm:ss"
		value="${moduleExtended.moduleHeader.insertTimestamp}" />
</c:if>
<br />
<c:if test="${moduleExtended.moduleHeader.updateTimestamp != null}">
	<s:label>update timestamp</s:label>
	<fmt:formatDate pattern="EEEE d MMMM yyyy HH:mm:ss"
		value="${moduleExtended.moduleHeader.updateTimestamp}" />
</c:if>
<br />
<br />


<h3>Module text</h3>
<c:if test="${moduleExtended.moduleType.textContent1Name != null}">
	<s:label value="%{moduleExtended.moduleType.textContent1Name}" />
	<c:out value="${moduleExtended.moduleText.text1Value}"></c:out>
</c:if>
<br />
<c:if test="${moduleExtended.moduleType.textContent2Name != null}">
	<s:label value="%{moduleExtended.moduleType.textContent2Name}" />
	<c:out value="${moduleExtended.moduleText.text2Value}"></c:out>
</c:if>
<br />
<c:if test="${moduleExtended.moduleType.textContent3Name != null}">
	<s:label value="%{moduleExtended.moduleType.textContent3Name}" />
	<c:out value="${moduleExtended.moduleText.text3Value}"></c:out>
</c:if>
<br />
<br />

<h3>Module Numeric</h3>
<c:if
	test="${moduleExtended.moduleType.numericDataContent1Name != null}">
	<s:label value="%{moduleExtended.moduleType.numericDataContent1Name}" />
	<c:out value="${moduleExtended.moduleNumeric.numericData1Value}"></c:out>
</c:if>
<br />
<c:if
	test="${moduleExtended.moduleType.numericDataContent2Name != null}">
	<s:label value="%{moduleExtended.moduleType.numericDataContent2Name}" />
	<c:out value="${moduleExtended.moduleNumeric.numericData2Value}"></c:out>
</c:if>
<br />
<c:if
	test="${moduleExtended.moduleType.numericDataContent3Name != null}">
	<s:label value="%{moduleExtended.moduleType.numericDataContent3Name}" />
	<c:out value="${moduleExtended.moduleNumeric.numericData3Value}"></c:out>
</c:if>
<br />
<br />



<h3>Module Datetime</h3>
<c:if test="${moduleExtended.moduleType.datetimeContent1Name != null}">
	<s:label value="%{moduleExtended.moduleType.datetimeContent1Name}" />
	
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
			<c:set var="formatDatetimeContent1" value="EEEE d MMMM yyyy HH:mm:ss" />
		</c:when>
	</c:choose>
<fmt:formatDate value="${moduleExtended.moduleDatetime.datetime1Value}" pattern="${formatDatetimeContent1}"/>
</c:if>
<br />

<c:if test="${moduleExtended.moduleType.datetimeContent2Name != null}">
	<s:label value="%{moduleExtended.moduleType.datetimeContent2Name}" />
	
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
			<c:set var="formatDatetimeContent2" value="EEEE d MMMM yyyy HH:mm:ss" />
		</c:when>
	</c:choose>
<fmt:formatDate value="${moduleExtended.moduleDatetime.datetime2Value}" pattern="${formatDatetimeContent2}"/>
</c:if>
<br />

<c:if test="${moduleExtended.moduleType.datetimeContent3Name != null}">
	<s:label value="%{moduleExtended.moduleType.datetimeContent3Name}" />
	
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
			<c:set var="formatDatetimeContent3" value="EEEE d MMMM yyyy HH:mm:ss" />
		</c:when>
	</c:choose>
<fmt:formatDate value="${moduleExtended.moduleDatetime.datetime3Value}" pattern="${formatDatetimeContent3}"/>
</c:if>
<br />
<br />


