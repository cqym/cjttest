<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en" class="app">


<aside class="bg-dark lter aside-md hidden-print" id="nav">
  <section class="vbox">
 
          <header class="header bg-primary lter text-center clearfix">
            <div class="btn-group">
              <button type="button" class="btn btn-sm btn-dark btn-icon" title="New project"><i class="fa fa-plus"></i></button>
              <div class="btn-group hidden-nav-xs">
                <button type="button" class="btn btn-sm btn-primary dropdown-toggle" data-toggle="dropdown"> Switch Project <span class="caret"></span> </button>
                <ul class="dropdown-menu text-left">
                  <li><a href="#">Project</a></li>
                  <li><a href="#">Another Project</a></li>
                  <li><a href="#">More Projects</a></li>
                </ul>
              </div>
            </div>
          </header>
    <section class="w-f scrollable">
      <div class="slim-scroll" data-height="auto" data-disable-fade-out="true" data-distance="0" data-size="5px" data-color="#333333"> <!-- nav -->
        <nav class="nav-primary hidden-xs">
          <ul class="nav">
            <li  class="active"> <a href="#layout" > <i class="fa fa-flask icon"> <b class="bg-success"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>测试管理</span> </a>
              <ul class="nav lt">
                <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>用例管理</span> </a> </li>
                <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>任务管理</span> </a> </li>
                <li > <a href="/Template/list" > <i class="fa fa-angle-right"></i> <span>模板管理</span> </a> </li>
                <li > <a href="/Template/add" > <i class="fa fa-angle-right"></i> <span>创建模板</span> </a> </li>
                <li > <a href="/sciptconfig/view" > <i class="fa fa-angle-right"></i> <span>配置脚本</span> </a> </li>
              </ul>
            </li>
            <li > <a href="#uikit" > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>基础数据</span> </a>
                    <ul class="nav lt">
                      <li > <a href="#"  > <i class="fa fa-angle-right"></i> <span>机器管理</span> </a> </li>
                      <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>版本管理</span> </a> </li>
                      <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>环境测试</span> </a> </li>
                      <li > <a href="/Template/list"  > <i class="fa fa-angle-right"></i> <span>基础数据</span> </a> </li>
                    </ul>
                  </li>
          </ul>
        </nav>
      </div>
    </section>
    <footer class="footer lt hidden-xs b-t b-dark">
      <div id="chat" class="dropup">
        <section class="dropdown-menu on aside-md m-l-n">
          <section class="panel bg-white">
            <header class="panel-heading b-b b-light">Active chats</header>
            <div class="panel-body animated fadeInRight">
              <p class="text-sm">No active chats.</p>
              <p><a href="#" class="btn btn-sm btn-default">Start a chat</a></p>
            </div>
          </section>
        </section>
      </div>
      <div id="invite" class="dropup">
        <section class="dropdown-menu on aside-md m-l-n">
          <section class="panel bg-white">
            <header class="panel-heading b-b b-light"> John <i class="fa fa-circle text-success"></i> </header>
            <div class="panel-body animated fadeInRight">
              <p class="text-sm">No contacts in your lists.</p>
              <p><a href="#" class="btn btn-sm btn-facebook"><i class="fa fa-fw fa-facebook"></i> Invite from Facebook</a></p>
            </div>
          </section>
        </section>
      </div>
      <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon"> <i class="fa fa-angle-left text"></i> <i class="fa fa-angle-right text-active"></i> </a>
      <div class="btn-group hidden-nav-xs">
        <button type="button" title="Chats" class="btn btn-icon btn-sm btn-dark" data-toggle="dropdown" data-target="#chat"><i class="fa fa-comment-o"></i></button>
        <button type="button" title="Contacts" class="btn btn-icon btn-sm btn-dark" data-toggle="dropdown" data-target="#invite"><i class="fa fa-facebook"></i></button>
      </div>
    </footer>
  </section>
</aside>
</html>
