<#macro sign_in path is_sign_in_form>
<form action="${path}" method="post">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Username:</label>
        <div class="col-sm-4">
            <input type="text" class="form-control" name="username" placeholder="Username"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Password:</label>
        <div class="col-sm-4">
            <input type="password" class="form-control" name="password" placeholder="Password"/>
        </div>
    </div>
    <#if !is_sign_in_form>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Email:</label>
        <div class="col-sm-4">
            <input type="email" class="form-control" name="email" placeholder="example@example.com"/>
        </div>
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-group row">
        <div class="col-sm-10">
            <button type="submit" class="btn btn-primary">
                <#if is_sign_in_form>Sign in<#else>Sign up</#if>
            </button>
        </div>
        <#if is_sign_in_form>
        <a href="/sign-up">Add new user</a>
        </#if>
    </div>
</form>
</#macro>

<#macro sign_out>
<div>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">
            Sign out
        </button>
    </form>
</div>
</#macro>