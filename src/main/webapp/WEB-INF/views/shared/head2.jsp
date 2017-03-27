<%--
  Created by IntelliJ IDEA.
  User: songtao
  Date: 23/3/17
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<header class="bg-dark dk header navbar navbar-fixed-top-xs">
  <div class="navbar-header aside-md"> <a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav"> <i class="fa fa-bars"></i> </a>  <a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user"> <i class="fa fa-cog"></i> </a> </div>

  <ul class="nav navbar-nav navbar-right hidden-xs nav-user">
    <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"> <span class="thumb-sm avatar pull-left"> <img src="/content/images/avatar.jpg"> </span> 薛亚斌 <b class="caret"></b> </a>
      <ul class="dropdown-menu animated fadeInRight">
        <span class="arrow top"></span>
        <li> <a href="#">Settings</a> </li>
        <li> <a href="profile.html">Profile</a> </li>
        <li> <a href="#"> <span class="badge bg-danger pull-right">3</span> Notifications </a> </li>
        <li> <a href="docs.html">Help</a> </li>
        <li class="divider"></li>
        <li> <a href="modal.lockme.html" data-toggle="ajaxModal" >Logout</a> </li>
      </ul>
    </li>
  </ul>
</header>
</html>
