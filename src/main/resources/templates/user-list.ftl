<#import "parts/common.ftl" as common>

<@common.page>
    List of users

<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as u>
    <tr>
        <td>${u.username}</td>
        <td><#list u.roles as r>${r}<#sep>, </#list></td>
        <td><a href="/user/${u.id}">Edit user</a></td>
    </tr>
    </#list>
    </tbody>
</table>

</@common.page>