<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="container-fluid padding-top">
	

		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label"
				name="moduleFinder.idModuleType" value="Module Type" />
			<div class="col-sm-4">
				<s:select list="userModuleType" listValue="name"
					listKey="idModuleType" headerKey="-1" headerValue="Choice"
					name="moduleFinder.idModuleType" label="ModuleType"
					cssClass="form-control" 
					onchange="ajaxCall('gotoUseModuleAjax?moduleType.idModuleType=%{idModuleType}','generalModuleForm')"></s:select>

			</div>
		</div>
	<br />
</div>






