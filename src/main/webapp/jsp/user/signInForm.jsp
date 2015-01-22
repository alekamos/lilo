<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container-fluid" id="signInFormDiv">

<s:form cssClass="form-horizontal" method="post" action="signIn.action"
	validate="true">
	<legend>Sign in</legend>
<!-- Form Name -->

	<div class="form-group">

		<s:label cssClass="col-sm-4 control-label" name="user.username" value="Username"/>
		<div class="col-sm-4">
			<s:textfield cssClass="form-control"
				name="user.username" placeholder="username" autocomplete="off" />
		</div>

	</div>
	<div class="form-group">
		<s:label cssClass="col-sm-4 control-label" name="user.password"
			value="Password" />
		<div class="col-sm-4">
			<s:password cssClass="form-control"
				name="user.password" placeholder="Password" autocomplete="off" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-4 col-sm-10">
			<s:submit cssClass="btn btn-light" value="Sign in" />
		</div>
	</div>

</s:form>
</div>

