<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div class="container-fluid" id="generalModuleForm">


	<s:form method="post" cssClass="form-horizontal"
		action="saveMultipleModuleXmlMassiveImport.action" validate="false">

		<legend>
			<span class="upper-case"><strong>Xml Massive Import</strong></span>
		</legend>

		<br />
		<span><small>Modificare il file xml aggiungendo
				all'inizio ed alla fine il tag 'listModuleExtended' e rimuovendo la
				prima riga dell'xml</small></span>
		<br />
		<br />



		<div class="form-group">
			<s:label cssClass="col-md-1 control-label" value="xml" />
			<div class="col-md-12">
				<s:textarea rows="35" cssClass="form-control" name="xmlInOut"
					autocomplete="on" />
			</div>
		</div>


		<div class="form-group">
			<div class="col-md-1">
				<s:submit cssClass="btn btn-light" value="Create" />
			</div>
		</div>


	</s:form>

</div>

