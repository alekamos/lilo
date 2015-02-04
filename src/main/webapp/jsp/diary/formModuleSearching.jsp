<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="container-fluid">
	<s:form cssClass="form-horizontal" action="viewModule">
		<legend>Search day</legend>

		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label"
				name="moduleFinder.dateDayHost" value="Date" />
			<div class="col-sm-4">
				<s:textfield name="moduleFinder.dateDayHost" id="datePicker"
					cssClass="form-control" placeholder="Date"></s:textfield>
			</div>
		</div>

		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label"
				name="moduleFinder.idModule" value="Id Module" />
			<div class="col-sm-4">
				<s:textfield name="moduleFinder.idModule" cssClass="form-control"
					placeholder="Id Module"></s:textfield>
			</div>
		</div>
		
<div class="form-group">
<s:label cssClass="col-sm-4 control-label"
				name="moduleFinder.idModuleType" value="Module Type" />
<div class="col-sm-4">
		<s:select list="userModuleType" listValue="name"
			listKey="idModuleType" headerKey="-1" headerValue="Choice"
			name="moduleFinder.idModuleType" label="ModuleType" cssClass="form-control"></s:select>
			
				</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-4 col-sm-10">
				<s:submit cssClass="btn btn-light" value="Search" />
			</div>
		</div>
	</s:form>
	<br />

	<table class="table">
		<tr>
			<c:forEach items="${navigatorElementList}" var="element">
				<c:set var="link"
					value="viewModule?moduleFinder.idModuleCluster=${element.idModuleCluster}" />
				<td><c:choose>
						<c:when test="${element.idModuleCluster != 0}">
							<a href="${link}"><fmt:formatDate value="${element.dateDay}"
									pattern="yy/MM/dd" /></a>
						</c:when>
						<c:when test="${element.idModuleCluster == 0}">
							<fmt:formatDate value="${element.dateDay}" pattern="yy/MM/dd" />
						</c:when>
					</c:choose></td>
			</c:forEach>
		</tr>
	</table>
</div>






