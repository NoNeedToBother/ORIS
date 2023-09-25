<html lang="en">
<#include "base.ftl">

<#macro title>Get Weather</#macro>
<#macro content>
    <form action="weather" method="post">
        Enter City:
        <input type="text" name="city"/>
        <br>
        <input type="submit" value="proceed">
    </form>
</#macro>
</html>