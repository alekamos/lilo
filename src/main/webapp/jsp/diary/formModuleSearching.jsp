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


<c:forEach items="${navigatorElementList}" var="element">
<c:out value="${element.dateDay}"></c:out>
		<a href="viewModule?moduleFinder.idModule=${element.idModule}"><fmt:formatDate
				value="${element.dateDay}" pattern="yyyy/MM/dd" /></a>
<br/>
</c:forEach>




