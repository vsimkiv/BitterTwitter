<#import "parts/common.ftl" as common>


<@common.page>

<a class="btn btn-primary" data-toggle="collapse" href="#newMessage" role="button" aria-expanded="false">
    New message
</a>

<div class="collapse" id="newMessage">
    <div class="form-group mt-2">
        <form method="post" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="text" placeholder="Message">
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="tag" placeholder="Tag">
            </div>
            <div class="custom-file mt-2">
                <input type="file" name="file" id="customFile">
                <label class="custom-file-label" for="customFile">Choose file</label>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Share</button>
            </div>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list messages as m>
        <div class="card my-2">
            <div class="card-img-top">
            <#if m.filename??>
                <img src="/img/${m.filename}">
            </#if>
            </div>
            <div class="card-body m-1">
                <span>${m.text}</span>
                <span><i>${m.tag}</i></span>
            </div>

            <div class="card-footer text-muted">
                ${m.authorName}
            </div>
        </div>
    <#else>
    No messages
    </#list>
</div>

</@common.page>