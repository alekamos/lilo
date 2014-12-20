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
	<s:textfield label="data Main Day" name="moduleExtended.dataMainDay"
		placeholder="data" autocomplete="off"/>

	<br />
	<h3>text content</h3>
	<c:if test="${moduleType.textContent1Name ne ''}">
		<s:textarea label="%{moduleType.textContent1Name}"
			name="moduleExtended.moduleText.text1Value" autocomplete="off" />
	</c:if>

	<c:if test="${moduleType.textContent2Name ne '' }">
		<s:textarea label="%{moduleType.textContent2Name}"
			name="moduleExtended.moduleText.text2Value" autocomplete="off" />
	</c:if>

	<c:if test="${moduleType.textContent3Name ne '' }">
		<s:textarea label="%{moduleType.textContent3Name}"
			name="moduleExtended.moduleText.text3Value" autocomplete="off" />
	</c:if>

	<br />
	<h3>list content</h3>


	<br />
	<h3>numeric content</h3>
	<c:if test="${moduleType.numericDataContent1Name ne '' }">
		<s:textfield label="%{moduleType.numericDataContent1Name}"
			name="moduleExtended.moduleNumeric.numericData1Value"
			autocomplete="off" />
	</c:if>

	<c:if test="${moduleType.numericDataContent2Name ne '' }">
		<s:textfield label="%{moduleType.numericDataContent2Name}"
			name="moduleExtended.moduleNumeric.numericData2Value"
			autocomplete="off" />
	</c:if>

	<c:if test="${moduleType.numericDataContent3Name ne '' }">
		<s:textfield label="%{moduleType.numericDataContent3Name}"
			name="moduleExtended.moduleNumeric.numericData3Value"
			autocomplete="off" />
	</c:if>


	<h3>date and time content</h3>
	<c:if test="${moduleType.datetimeContent1Name ne '' }">
		<s:textfield label="%{moduleType.datetimeContent1Name}"
			name="moduleExtended.moduleDatetime.datetime1Value"
			autocomplete="off" />
	</c:if>

	<c:if test="${moduleType.datetimeContent2Name ne '' }">
		<s:textfield label="%{moduleType.datetimeContent2Name}"
			name="moduleExtended.moduleDatetime.datetime2Value"
			autocomplete="off" />
	</c:if>

	<c:if test="${moduleType.datetimeContent3Name ne '' }">
		<s:textfield label="%{moduleType.datetimeContent3Name}"
			name="moduleExtended.moduleDatetime.datetime3Value"
			autocomplete="off" />
	</c:if>


	<br />

	<s:submit value="create" />
</s:form>


