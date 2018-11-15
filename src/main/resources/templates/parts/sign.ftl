<#macro sign_in path>
<form action="${path}" method="post">
    <div><label>Username: <input type="text" name="username"/></label></div>
    <div><label>Password: <input type="password" name="password"/></label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div><input type="submit" value="Sign in"/></div>
</form>
</#macro>

<#macro sign_out>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" value="Sign out">
    </form>
</div>
</#macro>