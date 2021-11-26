<#macro login path>
    <form action="${path}" method="post">
        <div><label>User name: <input type="text" name="username"/> </label></div>
        <div><label>Password: <input type="password" name="password"/> </label></div>
        <div><label>Email: <input type="text" name="email"/> </label></div>
        <div><label>Birth Date: <input type="date" name="birthday"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="Sign In"/></div>
    </form>
</#macro>