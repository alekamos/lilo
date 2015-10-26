<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container-fluid ">
<s:form  cssClass="form-horizontal" method="post" action="createNewModuleType.action" validate="false">

<legend><span class="upper-case"><strong>Create module type</strong></span></legend>


	<br />
		<h3 class="upper-case">naming</h3>
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label"
				name="moduleType.name" value="Name" />
	<div class="col-md-3"><s:textfield cssClass="form-control" name="moduleType.name"
		placeholder="name" autocomplete="off" /></div></div>
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label"
				name="moduleType.description" value="Description" />
	<div class="col-md-3"><s:textarea rows="10" cssClass="form-control" label="Naming - description" name="moduleType.description"
		placeholder="Description" autocomplete="off" /></div>
		</div>

	<br />
		<h3 class="upper-case">long text content</h3>
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label"
				name="moduleType.textContent1Name" value="Field name" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.textContent1Name" placeholder="field name"
		autocomplete="off" /></div></div>
		
	<br />
		<h3 class="upper-case">short text content</h3>
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label"
				name="moduleType.textContent2Name" value="Field name 1" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.textContent2Name" placeholder="field name"
		autocomplete="off" /></div></div>
		
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label"
				name="moduleType.textContent3Name" value="Field name 2" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.textContent3Name" placeholder="field name"
		autocomplete="off" /></div></div>


<!-- ========================List CONTENT======================= -->
<!--
	<br />
		<h3 class="upper-case">list content</h3>
		<div class="form-group">
	<div class="col-md-3"><s:textfield cssClass="form-control" 
		name="moduleType.listContent1Name" placeholder="field name"
		autocomplete="off" /></div></div>
	
	<div class="form-group">
	<div class="col-md-3"><s:textfield cssClass="form-control" 
		name="moduleType.listContent2Name" placeholder="field name"
		autocomplete="off" /></div></div>
		
		<div class="form-group">
	<div class="col-md-3"><s:textfield cssClass="form-control" 
		name="moduleType.listContent3Name" placeholder="field name"
		autocomplete="off" /></div></div>

	<br />
	
	
	<!-- ========================NUMERIC CONTENT======================= -->
		<h3 class="upper-case">numeric content</h3>
		
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label"
				name="moduleType.textContent3Name" value="Field name 1" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.numericDataContent1Name" placeholder="field name"
		autocomplete="off" /></div>
		

	<div class="col-md-3"><s:select cssClass="form-control"
		list="#{'INT':'INT', 'DOUBLE':'DOUBLE'}"
		name="moduleType.numericDataContent1Type" value="INT" /></div></div>
		

<div class="form-group">
<s:label cssClass="col-md-3 control-label"
				name="moduleType.textContent3Name" value="Field name 2" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.numericDataContent2Name" placeholder="field name"
		autocomplete="off" /></div>
		
	
	<div class="col-md-3"><s:select cssClass="form-control"
		list="#{'INT':'INT', 'DOUBLE':'DOUBLE'}"
		name="moduleType.numericDataContent2Type" value="INT" /></div></div>


<div class="form-group">
<s:label cssClass="col-md-3 control-label"
				name="moduleType.textContent3Name" value="Field name 3" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.numericDataContent3Name" placeholder="field name"
		autocomplete="off" /></div>
	<div class="col-md-3"><s:select cssClass="form-control"
		list="#{'INT':'INT', 'DOUBLE':'DOUBLE'}"
		name="moduleType.numericDataContent3Type" value="INT" /></div></div>


<!-- ========================DATE AND TIME======================= -->
	<br />
		<h3 class="upper-case">date and time content</h3>
	<div class="form-group">
	<s:label cssClass="col-md-3 control-label" value="Field name 1" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.datetimeContent1Name" placeholder="field name"
		autocomplete="off" /></div>
	<div class="col-md-3"><s:select cssClass="form-control"
		list="#{'DATE':'DATE', 'TIME':'TIME', 'DATETIME':'DATETIME'}"
		name="moduleType.datetimeContent1Type" value="DATE" />
</div></div>

<div class="form-group">
<s:label cssClass="col-md-3 control-label" value="Field name 2" />
	<div class="col-md-3"><s:textfield cssClass="form-control"
		name="moduleType.datetimeContent2Name" placeholder="field name"
		autocomplete="off" /></div>
	<div class="col-md-3"><s:select cssClass="form-control" 
		list="#{'DATE':'DATE', 'TIME':'TIME', 'DATETIME':'DATETIME'}"
		name="moduleType.datetimeContent2Type" value="DATE" /></div></div>
		
		
		<div class="form-group">
		<s:label cssClass="col-md-3 control-label" value="Field name 3" />
	<div class="col-md-3"><s:textfield cssClass="form-control" 
		name="moduleType.datetimeContent3Name" placeholder="field name"
		autocomplete="off" /></div>
	<div class="col-md-3"><s:select cssClass="form-control"
		list="#{'DATE':'DATE', 'TIME':'TIME', 'DATETIME':'DATETIME'}"
		name="moduleType.datetimeContent3Type" value="DATE" /></div></div>

	<br />

	<div class="form-group">
		<div class="col-sm-offset-3 col-sm-10">
		<s:submit cssClass="btn btn-light" value="Create" />
		</div>
		</div>
</s:form>
</div>


