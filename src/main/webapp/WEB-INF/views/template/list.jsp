<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="app">
<head>
  <c:import url="../shared/head.jsp">

  </c:import>
</head>
<body>
<section class="vbox">
  <%--<header class="bg-dark dk header navbar navbar-fixed-top-xs">--%>
    <%--<div class="navbar-header aside-md"> <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav"> <i class="fa fa-bars"></i> </a>  <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user"> <i class="fa fa-cog"></i> </a> </div>--%>

    <%--<ul class="nav navbar-nav navbar-right hidden-xs nav-user">--%>
      <%--<li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="thumb-sm avatar pull-left"> <img src="/content/images/avatar.jpg"> </span> 薛亚斌 <b class="caret"></b> </a>--%>
        <%--<ul class="dropdown-menu animated fadeInRight">--%>
          <%--<span class="arrow top"></span>--%>
          <%--<li> <a href="#">Settings</a> </li>--%>
          <%--<li> <a href="profile.html">Profile</a> </li>--%>
          <%--<li> <a href="#"> <span class="badge bg-danger pull-right">3</span> Notifications </a> </li>--%>
          <%--<li> <a href="docs.html">Help</a> </li>--%>
          <%--<li class="divider"></li>--%>
          <%--<li> <a href="modal.lockme.html" data-toggle="ajaxModal" >Logout</a> </li>--%>
        <%--</ul>--%>
      <%--</li>--%>
    <%--</ul>--%>
  <%--</header>--%>
    <c:import url="../shared/head2.jsp">

    </c:import>
  <section>
    <section class="hbox stretch">

      <!-- .aside -->
        <c:import url="../shared/nav.jsp">

        </c:import>
      <!-- /.aside -->
      <section id="content" style="background-color:#fff">
        <section class="vbox">
          <section class="scrollable padder">
            <ul class="breadcrumb no-border no-radius b-b b-light pull-in">
              <li><a href="/"><i class="fa fa-home"></i>自动化测试</a></li>
              <li class="active">模板列表</li>
            </ul>
            <section class="hbox stretch" style="height:90%">
              <aside>
                <section class="vbox">
                  <header class="header bg-white b-b clearfix">
                    <div class="row m-t-sm">
                      <div class="col-sm-8 m-b-xs">
                        <a href="/Template/add"  target="_blank" class="btn btn-s-md btn-info" style="background-color:#428bca; border-color:#428bca">新增模板</a>
                      </div>
                      <div class="col-sm-4 m-b-xs">
                        <div class="input-group">
                            <table class="table table-striped m-b-none">
                            <tr>
                        	<td width="15%" align="right"><label>名称：</label></td>
                              <td align="left"><input id="name" name="name" class="form-control" style="width:200px"  type="text"/>
                              </td>
                              <td align="right"><label>类型：</label></td>
                              <td align="left">
                              <select id="clientType" name="clientType" class="form-control" style="width:200px">
                                <option value="1">Http</option>
                                <option value="2">Interface</option>
                                <option value="3">Dubbo</option>
                              </select></td>
                              </tr>
                              </table>
                        <span class="input-group-btn">
                        <button class="btn btn-sm btn-default" type="button">查询</button>
                        </span> </div>
                      </div>
                    </div>
                  </header>
                  <section class="scrollable wrapper w-f">
                    <section class="panel panel-default">
                      <div class="table-responsive">
                        <table class="table table-striped m-b-none">
                          <thead>
                          <tr>
                            <th>模板名称</th>
                            <th>模板类型</th>
                            <th>备注</th>
                             <th>管理</th>
                          </tr>
                          </thead>
                          <tbody>
                          <c:forEach items="${templates}" var="templ">
                          <tr>
                            <td>${templ.name}</td>
                            <td>${templ.clientType}</td>
                            <td>${templ.discription}</td>
                            <td><a href="${ctx}/Template/update/${templ.id}">修改</a>
                            <a href="${ctx}/Template/delete/${templ.id}">删除</a>
                            </td>
                          </tr>
                          </c:forEach>

                          </tbody>
                        </table>
                      </div>
                    </section>
                  </section>



                  <!--page-->
                  ${page}
                  <!--page END-->
                </section>
              </aside>
            </section>
          </section>
        </section>
        <a href="#" class="hide nav-off-screen-block" data-toggle="class:nav-off-screen" data-target="#nav"></a> </section>
      <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
      </aside>
    </section>
  </section>
</section>

</body>
</html>
