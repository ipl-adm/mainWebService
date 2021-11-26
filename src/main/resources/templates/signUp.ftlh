<#import "parts/common.ftlh" as common>
<#import "parts/login.ftlh" as login>

<@common.page>
    Add new user
    ${errorMessage!" " }
    <@login.login "/signUp"></@login.login>
</@common.page>