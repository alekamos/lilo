<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container-fluid padding-top">
<a class="btn btn-large btn-primary" type="button" href="gotoNewModuleType">New Module Type</a>
<h2>Module List</h2>
<table class="table">
	<thead>
		<tr>

			<td>row</td>
			<td>detail</td>
			<td>use</td>
			<td>name</td>
			<td>desc</td>
		<tr>
	</thead>
	<tbody>
		<c:forEach items="${moduleTypeList}" var="mt" varStatus="i">
			<tr>
				<td><c:out value="${i.count}" /></td>
				<td><span class="glyphicon glyphicon-eye-open"></span></td>
				<td><a
					href="<s:url action="gotoUseModule.action" >
    <s:param name="moduleType.idModuleType">${mt.idModuleType}</s:param>
</s:url>"><span class="glyphicon glyphicon-plus-sign"></span></a></td>
				<td><c:out value="${mt.name}" /></td>
				<td><c:out value="${mt.description}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>

