<html lang="en">
<#include "base.ftl">

<#macro title>Login</#macro>
<#macro content>
    <form action="login" method="post">
        Enter Login:
        <input type="text" name="login"/>
        <br>
        Enter Password:
        <input type="password" name="password"/>
        <br>
        <input type="submit" value="login">
    </form>
</#macro>
</html>