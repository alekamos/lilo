<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>



<s:form action="viewModule">


	<s:textfield name="moduleFinder.dateDayHost" id="datePicker"
		label="date"></s:textfield>

	<s:textfield name="moduleFinder.idModule" label="idModule"></s:textfield>


	<s:select list="userModuleType" listValue="name" listKey="idModuleType"
		headerKey="-1" headerValue="Choice" name="moduleFinder.idModuleType"
		label="ModuleType"></s:select>

	<s:submit value="Search" />


</s:form>
<br/>

	<table class="table table-bordered">
		<tr>
			<c:forEach items="${navigatorElementList}" var="element">
				<c:set var="link"
					value="viewModule?moduleFinder.idModuleCluster=${element.idModuleCluster}" />
				<td><c:choose>
						<c:when test="${element.idModuleCluster != 0}">
							<a href="${link}"><fmt:formatDate value="${element.dateDay}"
									pattern="yyyy/MM/dd" /></a>
						</c:when>
						<c:when test="${element.idModuleCluster == 0}">
							<fmt:formatDate value="${element.dateDay}" pattern="yyyy/MM/dd" />
						</c:when>
					</c:choose></td>

			</c:forEach>
		</tr>
	</table>






