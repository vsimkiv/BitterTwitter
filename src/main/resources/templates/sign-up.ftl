<#import "parts/common.ftl" as common>
<#import "parts/sign.ftl" as sign>

<@common.page>
Add new user:
    ${info}
    <@sign.sign_in "/sign-up" />
</@common.page>