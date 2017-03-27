<%@ page import="com.chanjet.qm.common.tree.JsTree" %>
<%@ page import="com.google.gson.Gson" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<script src="/content/js/jquery-1.8.2.js"></script>
<script src="/content/js/bootstrap.js"></script>
<script src="/content/js/eden.ui.patch.js?${static_resource_version}"></script>
<script src="/content/js/jquery-ui-1.9.1.custom.js"></script>

<script src="/content/js/eden.tree.js"></script>
<script src="/content/js/eden.ui.helper.js?${static_resource_version}"></script>



<%
    Gson gson = new Gson();
    JsTree tree = (JsTree)request.getAttribute("tree");
    Integer id = (Integer)request.getAttribute("id");
%>


<!DOCTYPE html>
<html class="v_scrollbar">
<head>

    <%--<c:import url="../../shared/head.jsp">--%>
        <%--<c:param name="title" value="字典编辑"/>--%>
    <%--</c:import>--%>

    <style type="text/css">
        /* below 3 style will make nodes title wrap  */
        .jstree-default li a
        {
            white-space: normal !important;
            height: auto;
            padding: 1px 2px;
        }

        .jstree-default li > ins
        {
            vertical-align: top;
        }

        .jstree-default .jstree-hovered, .jstree-default .jstree-clicked
        {
            border: 0;
        }

        #tree_control li
        {
            min-height: 22px;
            line-height: 22px;
        }

        li.jstree-open > a .jstree-icon
        {
            height: 16px;
            width: 16px;
            background: url("/content/bootstrap/img/glyphicons-halflings.png") -408px -120px no-repeat !important;
        }

        li.jstree-closed > a .jstree-icon
        {
            height: 16px;
            width: 16px;
            background: url("/content/bootstrap/img/glyphicons-halflings.png") -384px -120px no-repeat !important;
        }

        li.jstree-leaf > a .jstree-icon
        {
            height: 16px;
            width: 16px;
            background: url("/content/bootstrap/img/glyphicons-halflings.png") -48px -120px no-repeat !important;
        }

        li.jstree-open.obsolete > a .jstree-icon
        {
            height: 16px;
            width: 16px;
            background: url("/content/bootstrap/img/glyphicons-halflings.png") -216px -96px no-repeat !important;
        }

        li.jstree-closed.obsolete > a .jstree-icon
        {
            height: 16px;
            width: 16px;
            background: url("/content/bootstrap/img/glyphicons-halflings.png") -216px -96px no-repeat !important;
        }

        li.jstree-leaf.obsolete > a .jstree-icon
        {
            height: 16px;
            width: 16px;
            background: url("/content/bootstrap/img/glyphicons-halflings.png") -216px -96px no-repeat !important;
        }

        .jstree .obsolete > a
        {
            color: gray;
        }

        #vakata-contextmenu ul li ins
        {
            display: none;
        }
    </style>


s
    <script src="/content/js/jquery.blockUI.js"></script>
    <script src="/content/jstree/jquery.jstree.js"></script>
    <script src="/content/jstree/jquery.hotkeys.js"></script>

    <script type="text/javascript">
    $(function () {
        $(document).ajaxStop($.unblockUI);
//            @Html.Jsonize("tree", @Model, false, true)
        var tree =<%=tree != null?gson.toJson(tree):"{\"root\":{\"data\":\"\",\"metadata\":{\"id\":0}}};\n"%>;

//        alert(Json.stringify(tree));
        alert("111");
        $.jstree._themes = "/Content/jstree/themes/";

        var tree_control = $('#tree_control');
        var rename_button = $('#rename_button'),
                remove_button = $('#remove_button'),
                obsolete_button = $('#obsolete_button'),
                add_brothers_button = $('#add_brothers_button'),
                add_children_button = $('#add_children_button'),
                batch_node_list = $('#batch_node_list'),
                save_button = $('#save_button'),
                tree_name_control = $('#tree_name_control');
        var new_node_name = "新节点";
        function BindTree() {
            tree_control.jstree({
                "plugins": ["themes", "json_data", "ui", "crrm", "dnd", "hotkeys", "unique", "contextmenu"],
                "ui": { select_multiple_modifier: false, select_range_modifier: false },
                "hotkeys": {
                    "del": deleteSelectNodes,
                    "space": obsoleteSelectNode,
                    "f2": renameNode
                },
                "contextmenu": {
                    "show_at_node": false, "select_node": true,
                    "items": {
                        "rename_node": {
                            "label": "修改节点", "action": function (obj) {
                                this.rename(obj);
                            }
                        },
                        "add_child": {
                            "label": "添加子节点", "action": function (obj) {
                                this.create(obj, 'inside', new_node_name);
                            }
                        },
                        "add_brother": {
                            "label": "添加兄弟节点", "action": function (obj) {
                                this.create(obj, 'after', new_node_name);
                            }
                        },
                        "obsolete_node": {
                            "label": "启用 / 禁用", "action": function (obj) {
                                //obj.toggleClass("obsolete");
                                obsoleteSelectNode();
                            }
                        },
                        "remove_node": {
                            "label": "删除节点", "action": deleteSelectNodes
                        },
                        "rename": false,
                        "remove": false,
                        "create": false,
                        "ccp": false
                    }
                },
                "unique": {
                    "error_callback": function (n, p, f) {
                        //showMessage("" + n + " 已经存在，在一个分支内不能创建同名的节点。");
                    }
                },
                "json_data": { "data": tree.root.children || [] }
            }).on('loaded.jstree', function () {
                tree_control.jstree('open_all');
                tree_control.jstree('select_node', tree_control.find('li')[0]);
            }).on("dblclick.jstree", function (event) {
                var node = $(event.target).closest("li");
                tree_control.jstree('rename', node);
            });

            tree_name_control.val(tree.root.data);
        }

        function showMessage(log, error) {
            setTimeout(function () {
                alert(log);
            }, 0);
        }

        function isOneNodeSelected() {
            if (tree_control.jstree('get_selected').length == 0) {
                showMessage('操作需要先选中一个节点。', true);
                return false;
            }
            if (tree_control.jstree('get_selected').length > 1) {
                showMessage('操作不作用于多个节点。', true);
                return false;
            }
            return true;
        }
        function confirmRemoveNodes() {
            var nodes = tree_control.jstree('get_selected');
            if (nodes.length == 0) {
                showMessage('先选中要删除的节点。', true);
                return false;
            }
            var names = [];
            $.map(nodes.find('a'), function (n) {
                names.push($.trim($(n).text()));
            });
            var nodeCount = names.length;
            var summaryNodes = 10;
            if (names.length > summaryNodes) {
                names.splice(summaryNodes, names.length - summaryNodes + 1, " 等");
            }
            if (!confirm('确认要删除 ' + names.join('、 ') + ' ' + nodeCount + ' 个节点么？')) { return false; }
            return true;
        }
        function getNodeListForAdd() {
            var items = $.trim(batch_node_list.val()).split('\n');
            items = $.map(items, function (n) { return $.trim(n); });
            items = $.grep(items, function (v, k) { return v.length > 0; });
            if (items.length === 0) {
                showMessage('在节点列表输入要批量添加的节点。', true);
                batch_node_list.focus();
                return null;
            }
            return items;
        }
        function treeMustHaveOneNode(withoutAlert) {
            if (tree_control.find('li').length == 0) {
                tree.root.children = [new_node_name];
                BindTree();
                if (withoutAlert == null) {
                    showMessage('至少需要包含一个节点。', true);
                }
            }
        }

        var renameNode = function () {
            if (!isOneNodeSelected()) { return; }
            tree_control.jstree('rename');
        };
        var deleteSelectNodes = function () {
            if (!confirmRemoveNodes()) { return; }
            tree_control.jstree('remove');
            treeMustHaveOneNode();
        };
        var obsoleteSelectNode = function () {
            if (!isOneNodeSelected()) { return; }
            var node = $(tree_control.jstree('get_selected'));
            node.toggleClass("obsolete");
            if (node.hasClass("obsolete")) {
                node.find("li").addClass("obsolete");
            }
            else {
                node.find("li").removeClass("obsolete");
            }
        };
        var addBrothers = function () {
            if (!isOneNodeSelected()) { return; }
            var items = getNodeListForAdd();
            if (items == null) { return; }
            for (var i = items.length - 1; i >= 0; i--) {
                tree_control.jstree('create', null, 'after', items[i], null, true);
            }
        };
        var addChildren = function () {
            if (!isOneNodeSelected()) { return; }
            var items = getNodeListForAdd();
            if (items == null) { return; }
            for (var i = items.length - 1; i >= 0; i--) {
                tree_control.jstree('create', null, 'inside', items[i], null, true);
            }
        };

        rename_button.on('click', renameNode);
        remove_button.on('click', deleteSelectNodes);
        obsolete_button.on('click', obsoleteSelectNode);
        add_brothers_button.on('click', addBrothers);
        add_children_button.on('click', addChildren);

        save_button.on('click', function () {
            var tree_name = $.trim(tree_name_control.val());
            if (tree_name.length == 0 || tree_name.length > 200) {
                showMessage("字典名称必须填写且长度不能多于 200 字。", true);
                tree_name_control.focus();
                return;
            }
            var json_data = tree_control.jstree('get_json', -1, ["class"], []);
            var json_tree = {
                "root": {
                    "data": tree_name_control.val(),
                    "metadata": { "id": tree.root.metadata.id },
                    "children": json_data
                }
            };

            $.blockUI({ message: '<h4>保存中……</h4>' });
            //console.log(JSON.stringify(json_tree));
            $.ajax({
                url: '/Admin/Tree/Edit<%=null!=id?"/"+id:""%>',
                type: 'POST',
                data: JSON.stringify(json_tree),
                dataType: 'json',
                processData: false,
                contentType: 'application/json; charset=utf-8'
            }).done(function (data) {
                tree = data;
                BindTree();
                //showMessage("保存成功。");
            }).fail(function (data) {
                showMessage("保存失败。", true);
            });
        });

        BindTree();
        setTimeout(function () {
            treeMustHaveOneNode(true);
        }, 0);
    });
    </script>
</head>
<body>

<%--<c:import url="../../Shared/HeaderNav.jsp"/>--%>

<div class="container">

    <!-- start: Page Title -->
    <div class="page-title">

        <h2>字典编辑4</h2>

    </div>
    <!-- end: Page Title -->

    <!-- start: wrapper -->
    <div class="wrapper">

        <!--start: Row -->
        <div class="row-fluid">

            <!--start: span5 -->
            <div class="span5">

                <div id="tree_control" style="height: 620px; overflow-x: hidden; overflow-y: auto;"></div>

            </div>
            <!--end: span5 -->

            <!--start: span7 -->
            <div class="span7">

                <form>
                    <p>
                        <label>字典名称</label>
                        <input type="text" id="tree_name_control" maxlength="200" />
                    </p>
                    <p class="btn-group">
                        <a href="#" class="btn" id="rename_button" title="修改节点">修改节点</a>
                        <a href="#" class="btn" id="obsolete_button" title="启用 / 禁用">启用 / 禁用</a>
                        <a href="#" class="btn" id="remove_button" title="删除节点">删除节点</a>
                    </p>
                    <p>
                        <label>批量添加节点</label>
                        <textarea id="batch_node_list" rows="10"></textarea>
                    <div>
                        <a href="#" class="btn" id="add_brothers_button" title="添加为兄弟节点">添加为兄弟节点</a>
                        <a href="#" class="btn" id="add_children_button" title="添加为子节点">添加为子节点</a>
                    </div>
                    </p>
                    <p>
                        <input id="save_button" type="button" class="btn btn-primary" data-loading-text="保存中..." value="保存" />
                    </p>
                </form>

                <ul>
                    <li>右键点击节点可以弹出快捷菜单。</li>
                    <li>双击编辑节点。</li>
                    <li>热键：
                        <ul>
                            <li>上下键，选择节点；</li>
                            <li>左右键，打开/关闭父节点；</li>
                            <li>空格键，启用/禁用节点，</li>
                            <li>F2 键，修改节点；</li>
                            <li>Delete 键，删除节点</li>
                        </ul>
                    </li>
                </ul>

            </div>
            <!--end: span7 -->

        </div>
        <!--end: Row -->

    </div>
    <!-- end: wrapper -->

</div>


<%--<jsp:include page="../../Shared/Footer.jsp"/>--%>

</body>
</html>
