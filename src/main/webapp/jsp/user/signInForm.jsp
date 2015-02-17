<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container-fluid" id="signInFormDiv">

<s:form cssClass="form-horizontal padding-top" method="post" action="signIn.action"
	validate="true">
	<legend>Sign in</legend>
<!-- Form Name -->

	<div class="form-group">

		<s:label cssClass="col-sm-4 control-label" name="user.username" value="Username"/>
		<div class="col-sm-4">
			<s:textfield cssClass="form-control"
				name="user.username" placeholder="Username" autocomplete="off" />
				<p class="help-block"><s:fielderror fieldName="user.username" /></p>
		</div>
	</div>
	<div class="form-group">
		<s:label cssClass="col-sm-4 control-label" name="user.password"
			value="Password" />
		<div class="col-sm-4">
			<s:password cssClass="form-control"
				name="user.password" placeholder="Password" autocomplete="off" />
				<p class="help-block"><s:fielderror fieldName="user.password" /></p>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-4">
			<s:submit cssClass="btn btn-light" value="Sign in" />
		</div>
	</div>

</s:form>
</div>

