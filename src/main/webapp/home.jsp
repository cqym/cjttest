<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String user=(String)session.getAttribute("user");
String right = (String)session.getAttribute("right");

%>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<title>Chanjet-Code</title>
<link rel="stylesheet" href="static/css/app.v2.css" type="text/css" />
<script src="<%=path%>/static/js/app.v2.js"></script>
<script src="static/js/jQuery/jquery-2.1.4.min.js"></script>
<script>

	function MenuClick(pagename){
		if($("#homeframe").attr("src")=="Develop/CodeReview/Report.jsp"||$("#homeframe").attr("src")=="Develop/CodeReview/TecReport.jsp")
		{
			if(($("#homeframe").contents().find("#Search").attr("disabled")!="disabled")&&($("#homeframe").contents().find("#testvalue").val()!=""||$("#homeframe").contents().find("#design").val()!=""||$("#homeframe").contents().find("#demand").val()!=""||$("#homeframe").contents().find("#code").val()!=""||$("#homeframe").contents().find("#allvalue").val()!=""||$("#homeframe").contents().find("#alldescribe").val().length!=0||$("#homeframe").contents().find("#checkdescribe").val().length!=0))
			{
				 if(confirm("您还没有编辑完成，确定要离开么？"))
				 {
					 $("#homeframe").attr("src",pagename);
				 }
			}
			else
			{
				$("#homeframe").attr("src",pagename);
			}
		}
		else
		{
			 $("#homeframe").attr("src",pagename);
		}
		
		
	}
</script>
</head>
<body>
<section class="vbox">
<header class="bg-dark dk header navbar navbar-fixed-top-xs">
	<div class="navbar-header aside-md">
		<a class="btn btn-link visible-xs" data-toggle="class:nav-off-screen" data-target="#nav"> 
			<i class="fa fa-bars"></i> 
		</a> 
		<a href="#" class="navbar-brand" data-toggle="fullscreen">
			<img src="images/logo.png" class="m-r-sm">Chanjet-TMS
		</a>
		<a class="btn btn-link visible-xs" data-toggle="dropdown" data-target=".nav-user">
			<i class="fa fa-cog"></i> 
		</a> 
	</div>
    <ul class="nav navbar-nav navbar-right hidden-xs nav-user">
    	<li class="dropdown"> 
    		<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
    			<span class="thumb-sm avatar pull-left"> <img src="images/avatar.jpg"> </span>
    			<span class="left-font02"><%=user%></span>
    			<b class="caret"></b>
    		</a>
		    <ul class="dropdown-menu animated fadeInRight">
		    	<!-- <li> <a href="./test/signout.json" data-toggle="ajaxModal" >退出</a> </li> -->
		    	<!--  href="./note/signin.jsp"  -->
		    	<li> <a onclick="signout()">退出</a> </li>
		    </ul>
      </li>
    </ul>
</header>
  <section>
    <section class="hbox stretch">
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
                  <li class="active"> <a  onclick="MenuClick('Home/home.jsp')"  class="active"> <i class="fa fa-dashboard icon"> <b class="bg-danger"></b> </i> <span>首页</span> </a> </li>
                  <li > <a href="#layout" > <i class="fa fa-columns icon"> <b class="bg-warning"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>启动</span> </a>
                    <ul class="nav lt">
                      <li > <a href="#" onclick="MenuClick('/cjt-tms/goods/list')" > <i class="fa fa-angle-right"></i> <span>商品管理</span> </a> </li>
                      <li > <a href="#" onclick="MenuClick('/cjt-tms/templ/templlist')" > <i class="fa fa-angle-right"></i> <span>模板管理</span> </a> </li>
                      <li > <a href="#" onclick="MenuClick('/cjt-tms/bootstrapTest')" > <i class="fa fa-angle-right"></i> <span>分页测试</span> </a> </li>
                      <li > <a href="#" onclick="MenuClick('/cjt-tms/testcase/testCaseView')" > <i class="fa fa-angle-right"></i> <span>用例管理</span> </a> </li>
                    </ul>
                  </li>
                  <li > <a href="#uikit" > <i class="fa fa-flask icon"> <b class="bg-success"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>需求</span> </a>
                    <ul class="nav lt">          
                      <li > <a href="#" ><i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i><span>需求文档走查</span> </a>
                        <ul class="nav bg">
                          <li > <a href="#" onclick="MenuClick('Requirement/ReqReview/ProReport.jsp')" > <i class="fa fa-angle-right"></i> <span>产品委员会走查填报</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Requirement/ReqReview/Report.jsp')" > <i class="fa fa-angle-right"></i> <span>部门内走查填报</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Requirement/ReqReview/ReportList.jsp')" > <i class="fa fa-angle-right"></i> <span>走查结果查询</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Requirement/ReqReview/ProReportTecList.jsp')" > <i class="fa fa-angle-right"></i> <span>产品委员会走查统计</span> </a> </li>
                       	</ul>
                      </li>
                    </ul>
                  </li>
                  <li > <a href="#uikit" > <i class="fa fa-flask icon"> <b class="bg-success"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>开发</span> </a>
                    <ul class="nav lt">
                      <!-- <li > <a href="#"  onclick="MenuClick('Develop/BugManage.jsp')" > <i class="fa fa-angle-right"></i> <span>缺陷管理</span> </a> 
                      	<ul class="nav bg">
                          <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>缺陷管理menu1</span> </a> </li>
                          <li > <a href="#" > <i class="fa fa-angle-right"></i> <span>缺陷管理menu2</span> </a> </li>
                        </ul>
                      </li> -->           
                      <li > <a href="#" ><i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i><span>质量管理</span> </a>
                        <ul class="nav bg">
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/sonarinfo.jsp')" > <i class="fa fa-angle-right"></i> <span>sonar数据查询</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/sonarrangelisttest.jsp')" > <i class="fa fa-angle-right"></i> <span>sonar汇总报表</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/sonarbaserangelist.jsp')" > <i class="fa fa-angle-right"></i> <span>双期数据比对</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/sonarattentionset.jsp')" > <i class="fa fa-angle-right"></i> <span>sonar关注项目管理</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/sonarcolumn.jsp')" > <i class="fa fa-angle-right"></i> <span>柱状图</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/DeveloperReport.jsp')" > <i class="fa fa-angle-right"></i> <span>研发日常数据报表</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Quality/DeveloperReportConfirm.jsp')" > <i class="fa fa-angle-right"></i> <span>研发日常数据快照保存</span> </a> </li>
                       	</ul>
                      </li>                     
                      <li > <a href="#" > <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i><span>代码管理</span> </a>
                        <ul class="nav bg">
                          <li > <a href="#" onclick="MenuClick('Develop/Code/ProjectManage.jsp')" > <i class="fa fa-angle-right"></i> <span>个人代码行统计</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Code/AllPersonInfoByNewStruct.jsp')" > <i class="fa fa-angle-right"></i> <span>产品代码行统计</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Code/QaProductInfoByNewStruct.jsp')" > <i class="fa fa-angle-right"></i> <span>方案代码行统计</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Code/SumCodeByPerson.jsp')" > <i class="fa fa-angle-right"></i> <span>部门人员代码行统计</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Code/QAByNewStruct.jsp')" > <i class="fa fa-angle-right"></i> <span>代码行查询方案管理</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/Code/UpSource.jsp')" > <i class="fa fa-angle-right"></i> <span>UpSource数据统计</span> </a> </li>
                        </ul>
                      </li>
                      <li > <a href="#" ><i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i><span>代码走查</span> </a>
                        <ul class="nav bg">
                          <li > <a href="#" onclick="MenuClick('Develop/CodeReview/TecReport.jsp')" > <i class="fa fa-angle-right"></i> <span>技术委员会走查填报</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/CodeReview/Report.jsp')" > <i class="fa fa-angle-right"></i> <span>部门内走查填报</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/CodeReview/ReportList.jsp')" > <i class="fa fa-angle-right"></i> <span>走查结果查询</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Develop/CodeReview/ReportTecList.jsp')" > <i class="fa fa-angle-right"></i> <span>技术委员会走查统计</span> </a> </li>
                          <!-- <li > <a href="#" onclick="MenuClick('Develop/CodeReview/Search.jsp')" > <i class="fa fa-angle-right"></i> <span>走查结果查询</span> </a> </li> -->
                        </ul>
                      </li>
                    </ul>
                  </li>
                  <li > <a href="#pages" > <i class="fa fa-file-text icon"> <b class="bg-primary"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span> <span>测试</span> </a>
                    <ul class="nav lt">
                      	<!-- <li > <a href="#"  onclick="MenuClick('note/404.html')"> <i class="fa fa-angle-right"></i> <span>自动化测试</span> </a> </li> -->
                    	<li > <a href="#" ><i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i><span>测试数据</span> </a>
                        <ul class="nav bg">
                          <li > <a href="#" onclick="MenuClick('Test/Data/Report.jsp')" > <i class="fa fa-angle-right"></i> <span>测试量化数据填报</span> </a> </li>
                          <li > <a href="#" onclick="MenuClick('Test/Data/Search.jsp')" > <i class="fa fa-angle-right"></i> <span>测试量化数据查询</span> </a> </li>
                       	</ul>
                      </li>
                      <li > <a href="#" ><i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i><span>质量管理</span> </a>
                        <ul class="nav bg">
                          <li > <a href="#" onclick="MenuClick('Test/Quality/TesterReport.jsp')" > <i class="fa fa-angle-right"></i> <span>测试日常数据报表</span> </a> </li>
                       	</ul>
                      </li>
                      </ul>
                  </li>
                  <li > <a href="#" > <i class="fa fa-envelope-o icon"> <b class="bg-primary dker"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span><span>发布</span> </a> 
                  	<ul class="nav lt">
                  	<!-- <li > <a href="#"  onclick="MenuClick('note/404.html')"> <i class="fa fa-angle-right"></i> <span>构建</span> </a></li>           
                      <li > <a href="#"  onclick="MenuClick('note/404.html')"> <i class="fa fa-angle-right"></i> <span>部署</span> </a></li> -->                     
                      <li > <a href="#"  onclick="MenuClick('Release/svninfo.jsp')"> <i class="fa fa-angle-right"></i> <span>发布</span> </a></li>
                      </ul>
                  </li>
                  <li > <a href="#"  onclick="MenuClick('note/404.html')"> <i class="fa fa-pencil icon"> <b class="bg-info"></b> </i> <span class="pull-right"> <i class="fa fa-angle-down text"></i> <i class="fa fa-angle-up text-active"></i> </span><span>归档</span> </a> </li>
                </ul>
              </nav>
			</div>
          </section>
          <footer class="footer lt hidden-xs b-t b-dark">
            <a href="#nav" data-toggle="class:nav-xs" class="pull-right btn btn-sm btn-dark btn-icon"> 
            	<i class="fa fa-angle-left text"></i> <i class="fa fa-angle-right text-active"></i>
            </a>
			</footer>
        </section>
      </aside>
	<section id="content">
        <iframe id="homeframe" src="Develop/Code/ProjectManage.jsp" style="border:0px" width="100%" height="100%"></iframe>
    </section>
	<aside class="bg-light lter b-l aside-md hide" id="notes">
		<div class="wrapper">Notification</div>
	</aside>
    </section>
  </section>
</section>
</body>
</html>
