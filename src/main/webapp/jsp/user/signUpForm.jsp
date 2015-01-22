<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="container-fluid" id="signUpFormDiv">

	<s:form cssClass="form-horizontal" method="post" action="signUp"
		validate="true">
		<legend>Sing Up</legend>

		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label" name="user.name"
				value="Name" />
			<div class="col-sm-4">
				<s:textfield cssClass="form-control" name="user.name" placeholder="name" autocomplete="off" />
				<p class="help-block"><s:fielderror fieldName="user.name" /></p>
			</div>
			
		</div>
		
		
		
		
		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label" name="user.surname"
				value="Surname" />
			<div class="col-sm-4">
				<s:textfield cssClass="form-control" name="user.surname" placeholder="surname"
					autocomplete="off" />
			</div>
		</div>
		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label" name="user.email"
				value="Email" />
			<div class="col-sm-4">
				<s:textfield cssClass="form-control" name="user.email" placeholder="email"
					autocomplete="off" />
			</div>
		</div>
		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label" name="user.birthDate"
				value="BirthDate" />
			<div class="col-sm-4">
				<s:textfield cssClass="form-control" name="user.birthDate" placeholder="birthDate"
					autocomplete="off" id="datePicker" />
			</div>
		</div>
		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label" name="user.username"
				value="Username" />
			<div class="col-sm-4">
				<s:textfield cssClass="form-control" name="user.username" placeholder="username"
					autocomplete="off" />
			</div>
		</div>
		<div class="form-group">
			<s:label cssClass="col-sm-4 control-label" name="user.password"
				value="Password" />
			<div class="col-sm-4">
				<s:password cssClass="form-control" name="user.password" placeholder="password"
					autocomplete="off" />
			</div>
		</div>
		<div class="form-group">
		<div class="col-sm-offset-4 col-sm-10">
		<s:submit cssClass="btn btn-light" value="Sign Up" />
		</div>
		</div>
	</s:form>
</div>