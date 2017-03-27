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
              <li class="active">模板添加</li>
            </ul>
            <section class="hbox stretch" style="height:90%">
              <!--真正的内容-->
              <aside>
                <section class="vbox">
                  <form action="/Template/${action}" method="post">
                  <input type="hidden" name="id" value="${template.id}"/>
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
                              <td width="15%" align="right"><label>名称：</label></td>
                              <td align="left"><input id="name" name="name" class="form-control" style="width:200px"
                                                      type="text" value="${templ.name}"/></td>
                            </tr>
                            <tr>
                              <td align="right"><label>类型：</label></td>
                              <td align="left"><select id="clientType" name="clientType" class="form-control" style="width:200px" value="${templ.clientType}" >
                                <option value="1" <c:if test="${'1' eq templ.clientType}">selected</c:if> >Http</option>
                                <option value="2" <c:if test="${'2' eq templ.clientType}">selected</c:if> >Interface</option>
                                <option value="3" <c:if test="${'3' eq templ.clientType}">selected</c:if> >Dubbo</option>
                              </select></td>
                            </tr>
                            <tr>
                              <td align="right"><label>备注：</label></td>
                              <td align="left"><input id="discription" name="discription" class="form-control"
                                                      style="width:200px" type="text" value="${templ.discription}"/></td>
                            </tr>
                            <tr>
                              <td align="right"><label>应答参数：</label></td>
                              <td align="left"><textarea name="request" id="request" class="form-control parsley-validated" style="width:380px"
                                                         rows="6" data-minwords="6" data-required="true" >${templ.request}</textarea>
                              </td>
                            </tr>
                            <tr>
                              <td align="right"><label>请求参数：</label></td>
                              <td align="left"><textarea id="response" name="response" class="form-control parsley-validated" style="width:380px"
                                                         rows="6" data-minwords="6" data-required="true">${templ.response}</textarea>
                              </td>
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
