<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<div class="container-fluid">
	<s:form cssClass="form-horizontal" method="post" action="viewModule"
		validate="false">
		<legend>
			<span class="upper-case"><strong>Search day</strong></span>
		</legend>


		<div id="stdResearchDiv">

			<button type="button" id="advSearchButton"
				class="btn btn-sm btn-primary"
				onclick="mostraDiv('advancedResearchDiv'), nascondiDiv('stdResearchDiv')">
				<span class="glyphicon glyphicon-plus"></span> Advanced search
			</button>


			<div class="form-group">
				<s:label cssClass="col-md-3 control-label"
					name="moduleFinder.dateDayHost" value="Date" />
				<div class="col-md-3">
					<s:textfield name="moduleFinder.dateDayHost"
						cssClass="form-control jqDatePicker" placeholder="Date"
						id="dateDayHost"></s:textfield>
				</div>
			</div>


		</div>


		<div id="advancedResearchDiv" style="display: none;">
			<br>

			<button type="button" id="closeButton" class="btn btn-sm btn-primary"
				onclick="nascondiDiv('advancedResearchDiv'),mostraDiv('stdResearchDiv') ">
				<span class="glyphicon glyphicon-remove"></span> Close
			</button>

			<div class="form-group">
				<s:label cssClass="col-md-3 control-label"
					value="Date Range" />
					
					
				<div class="col-md-3">
					<s:textfield cssClass="form-control jqDatePicker"
						name="moduleFinder.startDateDt" id="moduleFinder.startDateDt" placeholder="Start Date"
						autocomplete="off"/>
				</div>


				<div class="col-md-3">
					<s:textfield cssClass="form-control jqDatePicker" id="moduleFinder.endDateDt" name="moduleFinder.endDateDt"
						placeholder="End Date" autocomplete="off" />
				</div>
			</div>

			<div class="form-group">
				<s:label cssClass="col-md-3 control-label"
					name="moduleFinder.idModuleType" value="Module Type" />
				<div class="col-md-3">
					<s:select list="userModuleType" listValue="name"
						listKey="idModuleType" headerKey="-1" headerValue="Choice"
						name="moduleFinder.idModuleType" label="ModuleType"
						cssClass="form-control" id="idModuleType"></s:select>
				</div>
			</div>

			<div class="form-group">
				<s:label cssClass="col-md-3 control-label"
					name="moduleFinder.containedText" value="Contained Text" />
				<div class="col-md-3">
					<s:textfield name="moduleFinder.containedText"
						cssClass="form-control" placeholder="Contained text"
						id="containedText"></s:textfield>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-3 col-md-3">
				<s:submit cssClass="btn btn-light" value="Search" />
			</div>
		</div>

	</s:form>
</div>






