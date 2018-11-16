<#import "parts/common.ftl" as common>
<#import "parts/sign.ftl" as sign>

<@common.page>
    ${info!}
    <@sign.sign_in "/sign-in" true />
</@common.page>