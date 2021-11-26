<#import "parts/common.ftlh" as common>
<#import "parts/login.ftlh" as login>

<@common.page>
    Login Page
    <@login.login "/signIn" />
    <a href="/signUp">Add new user</a>
</@common.page>