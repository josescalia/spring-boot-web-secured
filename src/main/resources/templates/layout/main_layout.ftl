<#macro mainLayout>
<!DOCTYPE html>
<html lang="en">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/style.css">
<head>
    <title>Simple Spring Boot Web Application</title>
</head>
<body>
<div class="container" id="pageHeader">
    <h3>Simple Spring Web Applications</h3>
</div>
<div class="container" id="menuTop">
    <#include "../include/top_menu.html">
</div>
<div id="sessionInfo" class="container" style="border: 1px solid lightblue;margin-top:5px">

</div>
<div class="container" id="pageContent">
    <#nested/>
</div>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
    var htmlSession;
   /* $(function () {
        $.get("${springMacroRequestContext.contextPath}/security/info", function (jsonData) {
            if (jsonData.name != "anonymousUser") {
                htmlSession = "<div class='col-lg-6 col-md-6 col-sm-12 text-left'> You're logged in as <span class='text-info'>" + jsonData.name + "</span> and your role as <span class='text-warning'> " + jsonData.principal.authorities[0].authority + "</span></div>";
                htmlSession += "<div class='col-lg-6 col-md-6 col-sm-12 text-right'> <a href='${springMacroRequestContext.contextPath}/logout' class='btn btn-default btn-xs'><span class='glyphicon glyphicon-log-out'></span> Logout</a></div>";
            } else {
                htmlSession = "Hello Guest, Please Login <a href='${springMacroRequestContext.contextPath}/login'>Here</a>";
            }

            $("#sessionInfo").html(htmlSession);
        })
    })*/
</script>
</body>

</html>



</#macro>