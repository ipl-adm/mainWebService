<#import "parts/common.ftlh" as common>

<@common.page>
    <div class="container">
        <h1 class="display-4">${statusValue} - ${statusName}!</h1>

        ${exception}
        <p class="lead">${message}</p>
        {{/exception}}
    </div>
</@common.page>