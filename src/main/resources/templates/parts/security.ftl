<#assign
is_known = Session.SPRING_SECURITY_CONTEXT??
>

<#if is_known>
    <#assign
        user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = user.getUsername()
        is_admin = user.isAdmin()
    >
<#else>
    <#assign
        name = "Guest"
        is_admin = false
    >
</#if>

