<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$(document).ready(function() {


	//Datepicker pronto al caricamento della pagina
	$("#datePicker").datepicker({
		
	});

});

</script>
<div class="container-fluid" id="generalModuleForm">

<c:if test="${moduleType.name != null}">


<s:form method="post" cssClass="form-horizontal" action="saveModule.action" validate="false">

<legend><span class="upper-case"><strong>${moduleType.name}</strong></span></legend>
	
<br/>
<span><small>${moduleType.description}</small></span>
<br/>
	
	<s:hidden name="moduleExtended.moduleHeader.idModuleType"
		value="%{moduleType.idModuleType}" />

		<div class="form-group">
			<s:label cssClass="col-md-4 control-label"
				name="moduleExtended.moduleDayHost.dateDayHost" value="Day date" />
			<div class="col-md-4">
				<s:textfield id="datePicker" cssClass="form-control"
					name="moduleExtended.moduleDayHost.dateDayHost" placeholder="Date"
					autocomplete="off" />
				<p class="help-block">
					<s:fielderror fieldName="user.name" />
				</p>
			</div>
		</div>


		<c:if test="${moduleType.textContent1Name != null && moduleType.textContent1Name != ''}">
		<h4 class="upper-case">text content</h4>

		<div class="form-group"><s:label cssClass="col-md-4 control-label" name="moduleExtended.moduleText.text1Value"
			value="%{moduleType.textContent1Name}" />
			<div class="col-md-4">
		<s:textarea rows="3" cssClass="form-control" name="moduleExtended.moduleText.text1Value"
			autocomplete="off" /></div>
			</div>
	</c:if>

	<c:if
		test="${moduleType.textContent2Name != null && moduleType.textContent2Name != '' }">
		<div class="form-group"><s:label cssClass="col-md-4 control-label" name="moduleExtended.moduleText.text2Value"
			value="%{moduleType.textContent2Name}" />
			<div class="col-md-4">
		<s:textarea rows="3" cssClass="form-control" name="moduleExtended.moduleText.text2Value"
			autocomplete="off" /></div>
			</div>
	</c:if>

	<c:if
		test="${moduleType.textContent3Name != null && moduleType.textContent3Name != ''}">

		<div class="form-group"><s:label cssClass="col-md-4 control-label" name="moduleExtended.moduleText.text3Value"
			value="%{moduleType.textContent3Name}" />
		<div class="col-md-4"><s:textarea rows="3" cssClass="form-control" name="moduleExtended.moduleText.text3Value"
			autocomplete="off" />
			</div></div>
	</c:if>


	<c:if
		test="${moduleType.numericDataContent1Name != null && moduleType.numericDataContent1Name != ''}">
		<h4 class="upper-case">numeric content</h4>
		<br />
		<div class="form-group"><s:label cssClass="col-md-4 control-label" value="%{moduleType.numericDataContent1Name}" name="moduleExtended.moduleNumeric.numericData1Value"/>
		<div class="col-md-4"><s:textfield cssClass="form-control" name="moduleExtended.moduleNumeric.numericData1Value"
			autocomplete="off" /></div>
			</div>
	</c:if>

	<c:if
		test="${moduleType.numericDataContent2Name != null && moduleType.numericDataContent2Name != ''}">
		<div class="form-group"><s:label cssClass="col-md-4 control-label" value="%{moduleType.numericDataContent2Name}" name="moduleExtended.moduleNumeric.numericData2Value"/>
		<div class="col-md-4"><s:textfield cssClass="form-control" name="moduleExtended.moduleNumeric.numericData2Value"
			autocomplete="off" /></div></div>
	</c:if>

	<c:if
		test="${moduleType.numericDataContent3Name != null && moduleType.numericDataContent3Name != ''}">
		<div class="form-group"><s:label cssClass="col-md-4 control-label" value="%{moduleType.numericDataContent3Name}" name="moduleExtended.moduleNumeric.numericData3Value"/>
		<div class="col-md-4"><s:textfield cssClass="form-control" name="moduleExtended.moduleNumeric.numericData3Value"
			autocomplete="off" /></div></div>
	</c:if>



	<c:if
		test="${moduleType.datetimeContent1Name != null && moduleType.datetimeContent1Name != ''}">
		<h4 class="upper-case">date and time content</h4>
		<br />
		<div class="form-group"><s:label cssClass="col-md-4 control-label" value="%{moduleType.datetimeContent1Name}"/>
		<div class="col-md-4"><s:textfield cssClass="form-control" name="moduleExtended.moduleDatetime.datetime1Value"
			autocomplete="off" /></div></div>
	</c:if>

	<c:if
		test="${moduleType.datetimeContent2Name != null && moduleType.datetimeContent2Name != ''}">
		<div class="form-group"><s:label cssClass="col-md-4 control-label" value="%{moduleType.datetimeContent2Name}"/>
		<div class="col-md-4"><s:textfield cssClass="form-control" label="%{moduleType.datetimeContent2Name}"
			name="moduleExtended.moduleDatetime.datetime2Value"
			autocomplete="off" /></div></div>
	</c:if>

	<c:if
		test="${moduleType.datetimeContent3Name != null && moduleType.datetimeContent3Name != ''}">
		<div class="form-group"><s:label cssClass="col-md-4 control-label" value="%{moduleType.datetimeContent3Name}"/>
		<div class="col-md-4"><s:textfield cssClass="form-control" label="%{moduleType.datetimeContent3Name}"
			name="moduleExtended.moduleDatetime.datetime3Value"
			autocomplete="off" /></div></div>
	</c:if>


	<br />

	<div class="form-group">
		<div class="col-sm-offset-4 col-md-4">
		<s:submit cssClass="btn btn-light" value="Create" />
		</div>
		</div>
</s:form>
</c:if>
</div>

