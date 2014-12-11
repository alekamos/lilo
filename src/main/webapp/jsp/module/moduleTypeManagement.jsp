<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<a href="gotoNewModuleType">new module type</a>

<h2>Module List</h2>
<table>
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
				<td>x</td>
				<td>x</td>
				<td><c:out value="${mt.name}" /></td>
				<td><c:out value="${mt.description}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>


