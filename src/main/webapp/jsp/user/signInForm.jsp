<%@ taglib uri="/struts-tags" prefix="s"%>

<h1>Sing In</h1>
			
<s:form  method="post" action="signIn.action" validate="true">
    <s:textfield label="username" name="user.username" placeholder="username" autocomplete="off"/>
    <s:password label="password" name="user.password" placeholder="password" autocomplete="off"/>
    <s:submit value="Sign In"/>
</s:form>