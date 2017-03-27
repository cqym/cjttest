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
              <li class="active">用例添加</li>
            </ul>
            <section class="hbox stretch" style="height:90%">
              <!--真正的内容-->
              <aside>
                <section class="vbox">
                  <form action="/testcase/${action}" method="post">
                   <input type="hidden" name="id" value="${case.id}"/>
                    <header class="header bg-white b-b clearfix">
                      <div class="row m-t-sm">
                        <div class="col-sm-8 m-b-xs">
                          <a href="/Template/list" class="btn btn-s-md btn-info"
                             style="background-color:#428bca; border-color:#428bca">返回</a>
                          <input type="submit" class="btn btn-s-md btn-info"
                                 style="background-color:#428bca; border-color:#428bca" value="保存"/>
                        </div>
                        <div class="col-sm-4 m-b-xs">

                        </div>
                      </div>
                    </header>
                    <section class="scrollable wrapper w-f">
                      <section class="panel panel-default">
                        <div class="table-responsive">

                          <table style="margin:30px;width:100%">
                            <tr>
                            <td width="15%" align="right"><label>用例编号：</label></td>
                              <td align="left"><input id="caseNo" name="caseNo" class="form-control" style="width:200px"
                                                      type="text" value="${case.caseNo}"/></td>
                              <td width="15%" align="right"><label>用例名称：</label></td>
                              <td align="left"><input id="caseName" name="caseName" class="form-control" style="width:200px"
                                                      type="text" value="${case.caseName}"/></td>
                            </tr>
                            <tr>
                              <td align="right"><label>重要程度：</label></td>
                              <td align="left"><select id="clientType" name="clientType" class="form-control" style="width:200px">
                                <option value="1">高</option>
                                <option value="2">中</option>
                                <option value="3">低</option>
                              </select></td>
                               <td align="right"><label>优先级：</label></td>
                              <td align="left"><select id="clientType" name="clientType" class="form-control" style="width:200px">
                                <option value="1">高</option>
                                <option value="2">中</option>
                                <option value="3">低</option>
                              </select></td>
                            </tr>
                            <tr>
                              <td align="right"><label>用例描述：</label></td>
                              <td align="left"><input id="caseDisc" name="caseDisc" class="form-control"
                                                      style="width:200px" type="text"  value="${case.caseDisc}"/></td>
                            </tr>
                           

                          </table>


                        </div>
                      </section>
                    </section>

                  </form>


                  <footer class="footer bg-white b-t">

                  </footer>
                </section>
              </aside>

              <!--真正的内容结束-->
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
