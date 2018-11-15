<#import "parts/common.ftl" as common>
<#import "parts/sign.ftl" as sign>

<@common.page>
<div>
    <@sign.sign_out />
    <span><a href="/user">User list</a></span>
</div>

<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="text" placeholder="Message">
        <input type="text" name="tag" placeholder="Tag">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Share</button>
    </form>
</div>
<div>
    <#list messages as m>
</div>
    <div>
        <b>${m.id}</b>
        <span>${m.text}</span>
        <i>${m.tag}</i>
        <strong>${m.authorName}</strong>
        <div>
            <#if m.filename??>
                <img src="/img/${m.filename}">
            </#if>
        </div>
    </div>
    <#else>
    No messages
    </#list>
</@common.page>