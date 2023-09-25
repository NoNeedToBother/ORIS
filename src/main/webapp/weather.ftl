<html lang="en">
<#include "base.ftl">

<#macro title>Get Weather</#macro>
<#macro content>
    <div>
            Result:
        <br>
        <#if res=404>
            The city is not found.
        </#if>
        <#if res=401>
            The token is invalid.
        </#if>
        <#if res!=401 && res!=404 && res!=0>
            The error occurred.
        </#if>
        <#if res=0>
            Temperature: ${temperature} &degC
            <br>
            Humidity: ${humidity}%
            <br>
            Weather type: ${weathertype}
        </#if>
    </div>
</#macro>
</html>