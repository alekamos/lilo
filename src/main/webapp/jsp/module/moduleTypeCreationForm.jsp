<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
 

<s:form method="post" action="createNewModuleType.action" validate="false">
<h3>Naming</h3>
	<s:textfield label="name" name="moduleType.name" placeholder="name" autocomplete="off"/>
	<s:textarea label="description" name="moduleType.description" placeholder="description" autocomplete="off"/>
	
<h3>Text content</h3>
	<s:textfield label="field name 1" name="moduleType.textContent1Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="field name 2" name="moduleType.textContent2Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="field name 3" name="moduleType.textContent3Name" placeholder="field name" autocomplete="off"/>
	
<h3>List content</h3>
	<s:textfield label="field name 1" name="moduleType.listContent1Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="field name 2" name="moduleType.listContent2Name" placeholder="field name" autocomplete="off"/>
	<s:textfield label="field name 3" name="moduleType.listContent3Name" placeholder="field name" autocomplete="off"/>
	
<h3>Numeric content</h3>
	<s:textfield label="field name 1" name="moduleType.numericDataContent1Name" placeholder="field name" autocomplete="off"/>
	<s:select label="field type 1" 
		list="#{'int':'int', 'double':'double'}" 
		name="moduleType.numericDataContent1Type" value="int"
		/>
		
	<s:textfield label="field name" name="moduleType.numericDataContent2Name" placeholder="field name" autocomplete="off"/>
	<s:select label="field type 2" 
		list="#{'int':'int', 'double':'double'}" 
		name="moduleType.numericDataContent2Type" value="int"
		/>
		
	<s:textfield label="field name" name="moduleType.numericDataContent3Name" placeholder="field name" autocomplete="off"/>
	<s:select label="field type 3" 
		list="#{'int':'int', 'double':'double'}" 
		name="moduleType.numericDataContent3Type" value="int"
		/>
	
<h3>Date and time content</h3>
	<s:textfield label="field name 1" name="moduleType.datetimeContent1Name" placeholder="field name" autocomplete="off"/>
	<s:select label="field type 1" 
		list="#{'date':'date', 'time':'time', 'datetime':'date&time' }" 
		name="moduleType.datetimeContent1Type" value="date"
		/>
		
			<s:textfield label="field name 2" name="moduleType.datetimeContent2Name" placeholder="field name" autocomplete="off"/>
	<s:select label="field type 2" 
		list="#{'date':'date', 'time':'time', 'datetime':'date&time' }" 
		name="moduleType.datetimeContent2Type" value="date"
		/>
		
			<s:textfield label="field name 3" name="moduleType.datetimeContent3Name" placeholder="field name" autocomplete="off"/>
	<s:select label="field type 3" 
		list="#{'date':'date', 'time':'time', 'datetime':'date&time' }" 
		name="moduleType.datetimeContent3Type" value="date"
		/>
	
	
    <s:submit value="create"/>
</s:form>


