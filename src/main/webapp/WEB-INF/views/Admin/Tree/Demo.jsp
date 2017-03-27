
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>jsTree</title>
    <meta name="viewport" content="width=device-width" />
<head>
    <title></title>
    <link rel="stylesheet" href="/content/jstree2/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/content/jstree2/dist/themes/default/style.min.css"/>

    <script>window.$q=[];window.$=window.jQuery=function(a){window.$q.push(a);};</script>
</head>
<body>

<div class="container" id="content">


    <h3><i class="glyphicon glyphicon-leaf"></i>&nbsp;Contextmenu plugin2</h3>

    <div class="row">

        <div class="col-md-12">
            <div id="plugins2" class="demo plugin-demo">
                <%--<ul>--%>
                    <%--<li data-jstree='{"opened":true}'>Root node--%>
                        <%--<ul>--%>
                            <%--<li>Context click me</li>--%>
                        <%--</ul>--%>
                        <%--<ul>--%>
                            <%--<li>Drop me</li>--%>
                        <%--</ul>--%>
                    <%--</li>--%>
                <%--</ul>--%>
            </div>

        </div>
    </div>


    <!--.-->
</div>

<script>
    $(function () {
        alert("ssss");

//        $('#plugins2').jstree({
//            'core' : {
//
//            }
//        });

        $("#plugins2")
                .jstree({

                    "core": {
                        "check_callback": true,
                        "data" : [
                            {
                                "text" : "Root node",
                                "state" : { "opened" : true },
                                "children" : [
                                    {
                                        "text" : "Child node 1",
                                        "state" : { "selected" : true },
                                        "icon" : "jstree-file"
                                    },
                                    { "text" : "Child node 2", "state" : { "disabled" : true } }
                                ]
                            }
                        ]
                    },
                    "plugins": ["contextmenu", "dnd","wholerow"]
                });
    });
</script>

<script src="/content/jstree2/jquery-1.10.2.min.js"></script>


<script src="/content/jstree2/dist/jstree.min.js"></script>

<script>$.each($q, function (i, f) {$(f)});
$q = null;</script>
</body>
</html>