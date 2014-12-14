<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
 

<s:form method="post" action="createNewModuleType.action" validate="false">

	<s:textfield label="Naming - name" name="moduleType.name" placeholder="name" autocomplete="off"/>
	<s:textarea label="Naming - description" name="moduleType.description" placeholder="description" autocomplete="off"/>
	

	<s:textfield label="Text content-field name 1" name="moduleType.textContent1Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="Text content- field name 2" name="moduleType.textContent2Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="Text content- field name 3" name="moduleType.textContent3Name" placeholder="field name" autocomplete="off"/>
	

	<s:textfield label="List content-field name 1" name="moduleType.listContent1Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="List content-field name 2" name="moduleType.listContent2Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="List content-field name 3" name="moduleType.listContent3Name" placeholder="field name" autocomplete="off"/>
	

	<s:textfield label="Numeric content-field name 1" name="moduleType.numericDataContent1Name" placeholder="field name" autocomplete="off"/>
	<s:select label="Numeric contentfield type 1" 
		list="#{'int':'int', 'double':'double'}" 
		name="moduleType.numericDataContent1Type" value="int"
		/>
		
	<s:textfield label="Numeric content-field name" name="moduleType.numericDataContent2Name" placeholder="field name" autocomplete="off"/>
	<s:select label="Numeric content - field type 2" 
		list="#{'int':'int', 'double':'double'}" 
		name="moduleType.numericDataContent2Type" value="int"
		/>
		
	<s:textfield label="Numeric content-field name" name="moduleType.numericDataContent3Name" placeholder="field name" autocomplete="off"/>
	<s:select label="Numeric content-field type 3" 
		list="#{'int':'int', 'double':'double'}" 
		name="moduleType.numericDataContent3Type" value="int"
		/>
	

	<s:textfield label="Date and time content-field name 1" name="moduleType.datetimeContent1Name" placeholder="field name" autocomplete="off"/>
	<s:select label="Date and time content-field type 1" 
		list="#{'date':'date', 'time':'time', 'datetime':'date&time' }" 
		name="moduleType.datetimeContent1Type" value="date"
		/>
		
			<s:textfield label="Date and time content-field name 2" name="moduleType.datetimeContent2Name" placeholder="field name" autocomplete="off"/>
	<s:select label="Date and time content-field type 2" 
		list="#{'date':'date', 'time':'time', 'datetime':'date&time' }" 
		name="moduleType.datetimeContent2Type" value="date"
		/>
		
			<s:textfield label="Date and time content-field name 3" name="moduleType.datetimeContent3Name" placeholder="field name" autocomplete="off"/>
	<s:select label="Date and time content-field type 3" 
		list="#{'date':'date', 'time':'time', 'datetime':'date&time' }" 
		name="moduleType.datetimeContent3Type" value="date"
		/>
	
	
    <s:submit value="create"/>
</s:form>


