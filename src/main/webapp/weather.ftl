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
            <#if weatherinfo?has_content>
                Temperature: ${weatherinfo.temperature} &degC
                <br>
                Humidity: ${weatherinfo.humidity}%
                <br>
                Weather type: ${weatherinfo.weathertype}
            </#if>
        </#if>
    </div>
</#macro>
</html>