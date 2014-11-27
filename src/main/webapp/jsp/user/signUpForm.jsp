<%@ taglib uri="/struts-tags" prefix="s"%>

<h1>Sing Up</h1>
			
<s:form method="post" action="signUp.action" validate="true">
	<s:textfield label="name" name="user.name" placeholder="username" autocomplete="off"/>
	<s:textfield label="surname" name="user.surname" placeholder="surname" autocomplete="off"/>
	<s:textfield label="email" name="user.email" placeholder="email" autocomplete="off"/>
	<s:textfield label="birthDate" name="user.birthDate" placeholder="birthDate" autocomplete="off"/>
    <s:textfield label="username" name="user.username" placeholder="username" autocomplete="off"/> 
    <s:password label="password" name="user.password" placeholder="password" autocomplete="off"/>
    <s:submit value="Sign Up"/>
</s:form>