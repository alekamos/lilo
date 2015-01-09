<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<s:form method="post" action="saveModule.action" validate="false">


	<br />



	<h1>${moduleType.name}</h1>
	<h5>${moduleType.description}</h5>
	<s:hidden name="moduleExtended.moduleHeader.idModuleType"
		value="%{moduleType.idModuleType}" />
	<s:textfield label="data Main Day" id="datePicker"
		name="moduleExtended.moduleDayHost.dateDayHost" placeholder="data"
		autocomplete="off" />


	<c:if
		test="${moduleType.textContent1Name != null && moduleType.textContent1Name != ''}">
		<br />
		<h3>text content</h3>
		<s:label name="moduleExtended.moduleText.text1Value"
			value="%{moduleType.textContent1Name}" />
		<s:textarea name="moduleExtended.moduleText.text1Value"
			autocomplete="off" />
	</c:if>

	<c:if
		test="${moduleType.textContent2Name != null && moduleType.textContent2Name != '' }">
		<s:label name="moduleExtended.moduleText.text2Value"
			value="%{moduleType.textContent2Name}" />
		<s:textarea name="moduleExtended.moduleText.text2Value"
			autocomplete="off" />
	</c:if>

	<c:if
		test="${moduleType.textContent3Name != null && moduleType.textContent3Name != ''}">

		<s:label name="moduleExtended.moduleText.text3Value"
			value="%{moduleType.textContent3Name}" />
		<s:textarea name="moduleExtended.moduleText.text3Value"
			autocomplete="off" />
	</c:if>


	<c:if
		test="${moduleType.numericDataContent1Name != null && moduleType.numericDataContent1Name != ''}">
		<h3>numeric content</h3>
		<br />
		<s:label value="%{moduleType.numericDataContent1Name}" name="moduleExtended.moduleNumeric.numericData1Value"/>
		<s:textfield name="moduleExtended.moduleNumeric.numericData1Value"
			autocomplete="off" />
	</c:if>

	<c:if
		test="${moduleType.numericDataContent2Name != null && moduleType.numericDataContent2Name != ''}">
		<s:label value="%{moduleType.numericDataContent2Name}" name="moduleExtended.moduleNumeric.numericData2Value"/>
		<s:textfield name="moduleExtended.moduleNumeric.numericData2Value"
			autocomplete="off" />
	</c:if>

	<c:if
		test="${moduleType.numericDataContent3Name != null && moduleType.numericDataContent3Name != ''}">
		<s:label value="%{moduleType.numericDataContent3Name}" name="moduleExtended.moduleNumeric.numericData3Value"/>
		<s:textfield name="moduleExtended.moduleNumeric.numericData3Value"
			autocomplete="off" />
	</c:if>



	<c:if
		test="${moduleType.datetimeContent1Name != null && moduleType.datetimeContent1Name != ''}">
		<h3>date and time content</h3>
		<br />
		<s:label value="%{moduleType.datetimeContent1Name}"/>
		<s:textfield name="moduleExtended.moduleDatetime.datetime1Value"
			autocomplete="off" />
	</c:if>

	<c:if
		test="${moduleType.datetimeContent2Name != null && moduleType.datetimeContent2Name != ''}">
		<s:textfield label="%{moduleType.datetimeContent2Name}"
			name="moduleExtended.moduleDatetime.datetime2Value"
			autocomplete="off" />
	</c:if>

	<c:if
		test="${moduleType.datetimeContent3Name != null && moduleType.datetimeContent3Name != ''}">
		<s:textfield label="%{moduleType.datetimeContent3Name}"
			name="moduleExtended.moduleDatetime.datetime3Value"
			autocomplete="off" />
	</c:if>


	<br />

	<s:submit value="create" />
</s:form>


