<html lang="en">
<#include "base.ftl">

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<script>
    $(document).on("click", "#city_proceed", function () {
        let city = $("#city-input").val();
        $.get("/weather/util?city=" + city, function (response) {
            $("#content").text(response)
        })
    })
</script>

<#macro title>Get Weather</#macro>
<#macro content>
    <form>
        Enter City:
        <input id="city-input" type="text" name="city"/>
        <br>
        <input type="button" id="city_proceed" value="proceed">
    </form>

    <div id="content">
    </div>
</#macro>
</html>