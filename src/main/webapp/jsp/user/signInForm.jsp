<%@ taglib uri="/struts-tags" prefix="s"%>

<h1>Sing In</h1>

<s:form cssClass="form-horizontal" method="post" action="signIn.action"
	validate="true">
	<div class="form-group">

		<s:label cssClass="col-sm-2 control-label" name="user.username" value="Username"/>
		<div class="col-sm-10">
			<s:textfield cssClass="form-control"
				name="user.username" placeholder="username" autocomplete="off" />
		</div>

	</div>
	<div class="form-group">
		<s:label cssClass="col-sm-2 control-label" name="user.password"
			value="Password" />
		<div class="col-sm-10">
			<s:password cssClass="form-control"
				name="user.password" placeholder="Password" autocomplete="off" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<s:submit cssClass="btn btn-default" value="Sign in" />
		</div>
	</div>
</s:form>


