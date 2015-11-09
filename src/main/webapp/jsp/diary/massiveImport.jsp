<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid" id="generalModuleForm">


<s:form method="post" cssClass="form-horizontal" action="massiveImport.action" validate="false">

<legend><span class="upper-case"><strong>Massive Import</strong></span></legend>
	
<br/>
<span><small>edit content and save</small></span>
<br/>
	
	

		<div class="form-group"><s:label cssClass="col-md-3 control-label" name="content"
			value="content" />
			<div class="col-md-4">
		<s:textarea rows="30" cols="100" cssClass="form-control" name="xmlInOut"
			autocomplete="on" /></div>
			</div>
			
			
			<div class="form-group">
		<div class="col-sm-offset-4 col-md-4">
		<s:submit cssClass="btn btn-light" value="Create" />
		</div>
		</div>
	

</s:form>

</div>

