<html lang="en">
<#include "base.ftl">

<#macro title>
    Exception details
</#macro>
<#macro content>
    <h1>Exception details: </h1>
    <b>Request uri: </b>${uri}<br>
    <b>Status code: </b>${statusCode}<br>
    <#if message??><b>Message: </b>${message}</#if>
</#macro>
</html>