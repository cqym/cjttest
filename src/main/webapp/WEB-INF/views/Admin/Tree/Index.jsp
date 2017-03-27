<%@ page import="com.chanjet.qm.common.tree.Tree" %>
<%@ page import="com.google.common.base.Predicate" %>
<%@ page import="com.google.common.collect.FluentIterable" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<style type="text/css">
    a.item {
        display: block;
        text-align: center;
        text-decoration: none;
        color: #333;
    }

    a.item:hover {
        background: #e8e8e8;
        color: #000;
    }

    a.item i {
        margin-top: 3px;
        margin-right: 5px;
    }
</style>

<!DOCTYPE html>
<html class="v_scrollbar">
<head>

    <c:import url="../shared/head.jsp">
        <c:param name="title" value="系统管理"/>
    </c:import>

    <script></script>
</head>
<body>

<%--<c:import url="../../Shared/HeaderNav.jsp"/>--%>

<%
    List<Tree> trees = (List<Tree>) request.getAttribute("trees");
    Tree treeForOne = FluentIterable.from(trees).firstMatch(new Predicate<Tree>() {
        @Override
        public boolean apply(Tree tree) {
            return tree.getTreeID() == 1;
        }
    }).get();

    if (treeForOne != null) trees.remove(treeForOne);
%>

<div class="container">
    <!-- start: Page Title -->
    <div class="page-title">
        <%--<jsp:include page="../../Shared/AdminSubNav.jsp">--%>
            <%--<jsp:param name="Tag" value="tree"></jsp:param>--%>
        <%--</jsp:include>--%>
    </div>
    <!-- end: Page Title -->

    <!-- start: wrapper -->
    <div class="wrapper">

        <div class="control-panel">
            <h3>字典列表</h3>

            <div class="action form-inline">
                <a href="/Admin/Tree/Edit" class="btn btn-success">创建新字典</a>
                <a href="/Admin/Tree/Demo" class="btn">字典使用范例</a>
                <a href="/Admin/Tree/Edit/1" class="btn"><%=treeForOne.getName()%>></a>
            </div>
        </div>

    </div>
    <!-- end: wrapper -->
    <div class="row">
        <%
            for (Tree tree : trees) {
        %>
        <a href="/Admin/Tree/Edit/<%=tree.getTreeID()%>" class="wrapper item span3"><%=tree.getName()%>
        </a>
        <%
            }
        %>

    </div>


</div>

<%--<jsp:include page="../../Shared/Footer.jsp"/>--%>


</body>
</html>
