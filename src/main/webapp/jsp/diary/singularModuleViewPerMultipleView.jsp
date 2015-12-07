<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<% pageContext.setAttribute("newLine", "\n"); %>
<c:set var="subs" value="<br/>"/>



<!-- GENERAZIONE URL -->
<c:url value="gotoUpdateModule" var="update_url">
  <c:param name="moduleType.idModuleType" value="${moduleExtended.moduleType.idModuleType}" />
  <c:param name="moduleFinder.idModule"    value="${moduleExtended.moduleHeader.idModule}" />
</c:url>

<c:url value="deleteModule" var="delete_url">
  <c:param name="moduleExtended.moduleCluster.idModule" value="${moduleExtended.moduleHeader.idModule}" />
  <c:param name="moduleExtended.moduleCluster.idModuleCluster" value="${moduleExtended.moduleCluster.idModuleCluster}" />
</c:url>
<!-- GENERAZIONE URL -->


<div class="col-md-6">
<h1 class="upper-case"><strong>
	<c:out value="${moduleExtended.moduleType.name}" /></strong>
</h1>

<!-- TASTI DELETE/UPDATE -->
<a href="${update_url}" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-pencil"></span> Edit</a>
<a type="button" class="btn btn-primary"><span class="glyphicon glyphicon-remove"  data-toggle="modal" data-target="#myModal"></span> Delete</a>



<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Delete</h4>
      </div>
      <div class="modal-body">
        Are you sure delete this module?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <a href="${delete_url}" class="btn btn-danger" role="button">Delete</a>
      </div>
    </div>
  </div>
</div>


<c:if
	test="${(moduleExtended.moduleType.textContent1Name != null && moduleExtended.moduleType.textContent1Name != '') || (moduleExtended.moduleType.textContent2Name != null && moduleExtended.moduleType.textContent2Name != '') || (moduleExtended.moduleType.textContent3Name != null && moduleExtended.moduleType.textContent3Name != '')}">
<!-- 	<h3>Module text</h3> -->
	<c:if test="${moduleExtended.moduleType.textContent1Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.textContent1Name}"/></h3>
		<c:out value="${fn:replace(moduleExtended.moduleText.text1Value, newLine, subs)}" escapeXml="false"/>
	</c:if>
	<br />
	<c:if test="${moduleExtended.moduleType.textContent2Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.textContent2Name}" /></h3>
		<c:out value="${moduleExtended.moduleText.text2Value}" escapeXml="false"/>
	</c:if>
	<br />
	<c:if test="${moduleExtended.moduleType.textContent3Name != null}">
		<h3 class="upper-case"><c:out value="${moduleExtended.moduleType.textContent3Name}" /></h3>
		<c:out value="${moduleExtended.moduleText.text3Value}" escapeXml="false"/>
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

