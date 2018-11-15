<#import "parts/common.ftl" as common>

<@common.page>
    User editor
<form action="/user" method="post">
    <input type="text" name="username" value="${user.username}"/>
    <#list roles as r>
      <div>
          <label><input type="checkbox" name="${r}" ${user.roles?seq_contains(r)?string("checked", "")}>${r}</label>
      </div>
    </#list>
    <input type="hidden" name="user_id" value="${user.id}"/>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <button type="submit">Save</button>
</form>
</@common.page>