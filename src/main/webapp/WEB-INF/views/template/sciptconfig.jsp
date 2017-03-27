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
              <li><a href="index.html"><i class="fa fa-home"></i>自动化测试</a></li>
              <li class="active">创建模板</li>
            </ul>
            <section class="hbox stretch" style="height:90%">
              <aside>
                <a href="#" class="btn btn-s-md btn-info" style="background-color:#428bca; border-color:#428bca; margin-bottom:10px">新增步骤</a>
              <div class="row">
                <div class="col-sm-6">
                <section class="panel panel-default">
                  <header class="panel-heading"> <strong>模板</strong> </header>
                  <div class="panel-body">
                    <div class="table-responsive">
                      <table class="table table-striped m-b-none">
                        <thead>
                          <tr>
                            <th>模板名称</th>
                            <th>模板类型</th>
                            <th>备注</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>XXX</td>
                            <td>XXX</td>
                            <td>XXX</td>
                          </tr>
                            <tr>
                              <td>XXX</td>
                              <td>XXX</td>
                              <td>XXX</td>
                            </tr>
                              <tr>
                                <td>XXX</td>
                                <td>XXX</td>
                                <td>XXX</td>
                              </tr>
                                <tr>
                                  <td>XXX</td>
                                  <td>XXX</td>
                                  <td>XXX</td>
                                </tr>
                                  <tr>
                                    <td>XXX</td>
                                    <td>XXX</td>
                                    <td>XXX</td>
                                  </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </section>
              </div>
                <div class="col-sm-6">
                <section class="panel panel-default">
                  <header class="panel-heading bg-light">
                    <ul class="nav nav-tabs nav-justified">
                      <li class="active"><a href="#home" data-toggle="tab">请求参数</a></li>
                      <li><a href="#profile" data-toggle="tab">应答参数</a></li>
                    </ul>
                  </header>
                  <div class="panel-body">
                    <div class="tab-content">
                      <div class="tab-pane active" id="home">
                        <textarea class="form-control parsley-validated" style="width:464px;height:500px" rows="6" data-minwords="6" data-required="true">
POST $Url$ HTTP/1.1
Host: $Host$
Content-Type: text/xml
Content-Length: $Content-Length-value$
Accept-Charset: $Accept-Charset-value$
Accept-Language: $Accept-Language-value$

<config>
<client type="PC" version="3.6.0540" platform="W5.1"/>
<user sid="$sid-value$" mobile-no="$mobile-no-value$" />
<servers version="0" />
<service-no version="0" />
<parameters version="0" />
<hints version="11" />
<http-applications version="0" />
<client-config version="0" />
<services version="$11$" />
<toolbars version="$12$" />
<banners version="$13$" />
</config>
                        </textarea>
                      </div>
                      <div class="tab-pane" id="profile">
                        <textarea class="form-control parsley-validated" style="width:464px;height:500px" rows="6" data-minwords="6" data-required="true">
                          HTTP/1.1 200
                          Content-Type:$text/xml$
                          Content-Length: $Content-Length-value$
                          Content-Language: $Content-Language-value$
                          Date: $Date-value$

                          <config carrier="$CMCC$" isp="$CUC$">
                          	<servers version="$servers-version-value$">
                          		<server-caps>$server-capability-list$</server-caps>
                          		<server-version>$server-version-value$</server-version>
                          		<sipc-proxy>$sip-proxy-value$</sipc-proxy>
                          		<sipc-ssl-proxy>$sip-proxy-value$</sipc-ssl-proxy>
                          		<http-tunnel>$http-tunnel-value$</http-tunnel>
                          		<j2me-adapter>$j2me-adapter-value$</j2me-adapter>
                          		<smartphone-adapter>$smartphone-adapter-value$</smartphone-adapter>
                          		<portal>$self-help-portal-value$</portal>
                          		<get-uri>$get-uri-value$</get-uri>
                          		<get-system-status>$get-system-status-value$</get-system-status>
                          		<get-pic-code>$get-pic-code-value$</get-pic-code>
                          		<apply-sub-service>$apply-sub-service-value$</apply-sub-service>
                          		<sub-service>$sub-service-value$</sub-service>
                          		<get-general-info>$get-general-info-value$</get-general-info>
                          		<ssi-app-sign-in>$ssi-app-sign-in-url$</ssi-app-sign-in>
                          		<ssi-app-sign-in-v2>$ssi-app-sign-in-v2-url$</ssi-app-sign-in-v2>
                          		<ssi-app-sign-out>$ssi-app-sign-out-url$</ssi-app-sign-out>
                          		<get-svc-order-status>$get-svc-order-status-value$</get-svc-order-status>
                          		<matching-portal>$matching-portal-value$</matching-portal>
                          		<crbt-portal>$crbt-portal-value$</crbt-portal>
                          		<update-pwd>$update-pwd-url$</update-pwd>
                          		<group-category>$group-category-url$</group-category>
                          		<group-website>$group-website-url$</group-website>
                          		<stun-urls>$stun-urls$</stun-urls>
                          		<wap-client-sign-in>$wap-client-sign-in-value$</wap-client-sign-in>
                          		<email-adapter>$email-adapter-value$</email-adapter>
                          	</servers>
                          	<service-no version="$version-value$">
                          		<sms>$sms-service-no-value$</sms>
                          		<mms>$mms-service-no-value$</mms>
                          		<rbt>$rbt-service-no-value$</rbt>
                          		<ivr>$ivr-service-no-value$</ivr>
                          		<help-desk>$call-center-no-value$</help-desk>
                          	</service-no>
                          	<parameters version="$version-value$">
                          		<max-buddies>$max-buddies-value$</max-buddies>
                          		<max-chat-buddies>$max-chat-friends-value$</max-chat-buddies>
                          		<max-buddy-list>$max-contact-list-value$</max-buddy-list>
                          		<max-blacklist>$max-blacklist-value$</max-blacklist>
                          		<max-msg-length>$max-msg-length-value$</max-msg-length>
                          		<max-sms-length>$max-sms-length-value$</max-sms-length>
                          		<max-msg-convert-sms>$max-msg-convert-sms-value$</max-msg-convert-sms>
                          		<single-sms-max-length>$single-sms-max-length-value$</single-sms-max-length>
                          		<max-sms-unicode>$max-sms-unicode-value$</max-sms-unicode>
                          		<max-ivr-participants>$max-ivr-participants-value$</max-ivr-participants>
                          		<ivr-invite-timeout>$ivr-invite-timeout-value$</ivr-invite-timeout>
                          		<portrait-file-type>$portrait-file-type-value$</portrait-file-type>
                          		<forbidden-share-content-type>$forbidden-share-content-type-value$</forbidden-share-content-type>
                          		<max-share-content-size>$max-share-content-size-value$</max-share-content-size>
                          		<offline-max-share-content-size>$offline-max-share-content-size-value$</offline-max-share-content-size>
                          		<temp-group-max-share-content-size>$temp-group-max-share-content-size-value$</temp-group-max-share-content-size>
                          		<batch-sms-max-receivers>$batch-sms-max-receivers-value$</batch-sms-max-receivers>
                          		<vip-batch-sms-max-receivers>$vip-batch-sms-max-receivers-value$</vip-batch-sms-max-receivers>
                          		<groupcategory-version>$groupcategory-version-value$</groupcategory-version>
                          		<max-superadmin-count>$max-superadmin-count-value$</max-superadmin-count>
                          		<max-joingroup-count>$max-joingroup-count-value$</max-joingroup-count>
                          		<max-groupadmin-count>$max-groupadmin-count-value$</max-groupadmin-count>
                          		<max-groupuser-count>$max-groupuser-count-value$</max-groupuser-count>
                          		<max-joingroup-invite-count>$max-joingroup-invite-count-value$</max-joingroup-invite-count>
                          		<max-daily-sms-time>$max-daily-sms-time-value$</max-daily-sms-time>
                          		<max-month-sms-time>$max-month-sms-time-value$</max-month-sms-time>
                          		<searchgroup-pagesize>$searchgroup-pagesize-value$</searchgroup-pagesize>
                          		<score-config>$score-config-value$</score-config>
                          		<max-voice-clip-size>$max-voice-clip-size-value$</max-voice-clip-size>
                          		<voice-clip-encoding>$voice-clip-encoding-value$</voice-clip-encoding>
                          		<max-emotion-pic-size>$max-emotion-pic-size-value$</max-emotion-pic-size>
                          		<max-emotion-pic-rect>$max-emotion-pic-rect-value$</max-emotion-pic-rect>
                          		<password-strength>$password-strength-value$</password-strength>
                          	</parameters>
                          	<hints version="$version-value$">
                          		<user-busy>$user-busy-hint-value$</user-busy>
                          		<user-sms-status>$user-sms-status-hint-value$</user-sms-status>
                          		<user-offline>$user-offline-hint-value$</user-offline>
                          		<participants-not-online>$participants-not-online-hint-value$</participants-not-online>
                          		<user-in-blacklist>$user-in-blacklist-hint-value$</user-in-blacklist>
                          		<i-not-log-on>$i-not-log-on-hint-value$</i-not-log-on>
                          		<i-not-online>$i-not-online-hint-value$</i-not-online>
                          		<addbuddy-phrases>$invite-phrases-value$</addbuddy-phrases>
                          	</hints>
                          	<http-applications version="$version-value$">
                          		<get-group-portrait>$get-group-portrait-value$</get-group-portrait>
                          		<set-group-portrait>$set-group-portrait-value$</set-group-portrait>
                          		<get-portrait>$get-portrait-value$</get-portrait>
                          		<set-portrait>$set-portrait-value$</set-portrait>
                          		<del-portrait>$del-portrait-value$</del-portrait>
                          		<upload-share-content>$upload-share-content-value$</upload-share-content>
                          		<relay-upload-share-content>$relay-upload-share-content-value$</relay-upload-share-content>
                          		<query-msg-history>$query-msg-history-value$</query-msg-history>
                          		<delete-msg-history>$delete-msg-history-value$</delete-msg-history>
                          		<get-ad>$get-ad-value$</get-ad>
                          		<record-share-content-op>$record-share-content-op-value$</record-share-content-op>
                          		<set-personal-info>$set-personal-info-value$</set-personal-info>
                          		<get-personal-info>$get-personal-info-value$</get-personal-info>
                          		<get-personal-ext-info>$get-personal-ext-info-value$</get-personal-ext-info>
                          		<crbt-common-access>$crbt-common-access-value$</crbt-common-access>
                          		<set-tone-info>$set-tone-info-value$</set-tone-info>
                          		<get-tab-info>$get-tab-info-value$</get-tab-info>
                          		<get-addressbook-config>$get-addressbook-config-value$</get-addressbook-config>
                          		<set-addressbook-info>$set-addressbook-info-value$</set-addressbook-info>
                          		<get-addressbook-info>$get-addressbook-info-value$</get-addressbook-info>
                          		<phoenix-info-url>$phoenix-info-url-value$</phoenix-info-url>
                          		<check-emotion-pic-url>$check-emotion-pic-url-value$</check-emotion-pic-url>
                          		<set-emotion-pic-url>$set-emotion-pic-url-value$</set-emotion-pic-url>
                          		<get-emotion-pic-url>$get-emotion-pic-url-value$</get-emotion-pic-url>
                          		<feip-url>$feip-url-value$</feip-url>
                                          <weather-info-url>$weather-info-url-value$</weather-info-url>
                          		<get-personal-blog-info>$get-blog-info-value$</get-personal-blog-info>
                          		<get-contact-blog-info>$get-contact-blog-info-value$</get-contact-blog-info>
                          	</http-applications>
                          	<client-config version="$client-config-version-value$">
                          		<item key="$sms-mode-main-desc$" value="$sms-mode-main-desc-value$"/>
                          		<item key="$sms-mode-invite-buddy$" value="$sms-mode-invite-buddy-value$"/>
                          		<item key="$sms-mode-invite-ivr$" value="$sms-mode-invite-ivr-value$"/>
                          		<item key="$sms-mode-no-contact-list$" value="$sms-mode-no-contact-list-value$"/>
                          		<item key="$online-no-buddies$" value="$online-no-buddies-value$"/>
                          		<item key="$online-garden-desc$" value="$online-garden-desc-value$"/>
                          		<item key="$mobile-no-dist$" value="$mobile-no-dist-value$"/>
                          		<item key="$fee-charge-desc-url$" value="$fee-charge-desc-url-value$"/>
                          		<item key="$ivr-charge-desc$" value="$ivr-charge-desc-value$"/>
                          		<item key="$info-redirect-url$" value="$info-redirect-url-value$"/>
                          		<item key="$sysmsg-daily-display-count$" value="$sysmsg-daily-display-count-value$"/>
                          		<item key="$j2mev2-resource-download-url$" value="$j2mev2-resource-download-url-value$"/>
                          		<item key="$group-meaning-url$" value="$group-meaning-url-value$"/>
                          		<item key="$how-to-create-group-url$" value="$how-to-create-group-url-value$"/>
                          		<item key="$how-to-find-group-url$" value="$how-to-find-group-url-value$"/>
                          		<item key="$no-responsibility-declaration-url$" value="$no-responsibility-declaration-url-value$"/>
                          		<item key="$score-faq-url$" value="$score-faq-url-value$"/>
                          		<item key="$enable-search-service$" value="$enable-search-service-value$"/>
                          		<item key="$enable-addressbook$" value="$enable-addressbook-value$"/>
                          	</client-config>
                          	<client version="$client-software-version-value$">
                          		<compatible>$compatible-value$</compatible>
                          		<date>$date-value$</date>
                          		<install-uri size="$install-file-size$">$install-uri-value$</install-uri>
                          		<pc-live-update value="$pc-live-update-uri$"/>
                          		<file-uri size="$file-size$">$file-uri-value$</file-uri>
                          	</client>
                          </config>
                        </textarea>
                      </div>
                    </div>
                  </div>
                </section>
              </div>
              </div>

              <div class="row">
                <div class="col-sm-6">
                  <section class="panel panel-default">
                  <header class="panel-heading"> <strong>请求</strong> </header>
                  <div class="panel-body">
                    <div class="table-responsive">
                      <table class="table table-striped m-b-none">
                        <thead>
                          <tr>
                            <th style="width:25%">name</th>
                            <th>value</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>$1$</td>
                            <td><input class="form-control" style="width:200px" type="text" /></td>
                          </tr>

                            <tr>
                              <td>$1$</td>
                              <td><input class="form-control" style="width:200px" type="text" /></td>
                            </tr>
                              <tr>
                                <td>$1$</td>
                                <td><input class="form-control" style="width:200px" type="text" /></td>
                              </tr>
                                <tr>
                                  <td>$1$</td>
                                  <td><input class="form-control" style="width:200px" type="text" /></td>
                                </tr>
                                  <tr>
                                    <td>$1$</td>
                                    <td><input class="form-control" style="width:200px" type="text" /></td>
                                  </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </section>
                </div>
                <div class="col-sm-6">
                  <section class="panel panel-default">
                  <header class="panel-heading"> <strong>应答</strong> </header>
                  <div class="panel-body">
                    <div class="table-responsive">
                      <table class="table table-striped m-b-none">
                        <thead>
                          <tr>
                            <th style="width:25%">name</th>
                            <th>value</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>$1$</td>
                            <td><input class="form-control" style="width:200px" type="text" /></td>
                          </tr>

                            <tr>
                              <td>$1$</td>
                              <td><input class="form-control" style="width:200px" type="text" /></td>
                            </tr>
                              <tr>
                                <td>$1$</td>
                                <td><input class="form-control" style="width:200px" type="text" /></td>
                              </tr>
                                <tr>
                                  <td>$1$</td>
                                  <td><input class="form-control" style="width:200px" type="text" /></td>
                                </tr>
                                  <tr>
                                    <td>$1$</td>
                                    <td><input class="form-control" style="width:200px" type="text" /></td>
                                  </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </section>
                </div>
              </div>
              <div class="row">
                <div class="col-sm-6">
                  <section class="panel panel-default">
                  <header class="panel-heading"> <strong>关联</strong> </header>
                  <div class="panel-body">
                    <div class="table-responsive">
                      <table class="table table-striped m-b-none">
                        <thead>
                          <tr>
                            <th style="width:25%">name</th>
                            <th>value</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td>XXX</td>
                            <td>XXX</td>
                          </tr>
                            <tr>
                              <td>XXX</td>
                              <td>XXX</td>
                            </tr>
                              <tr>
                                <td>XXX</td>
                                <td>XXX</td>
                              </tr>
                                <tr>
                                  <td>XXX</td>
                                  <td>XXX</td>
                                </tr>
                                  <tr>
                                    <td>XXX</td>
                                    <td>XXX</td>
                                  </tr>
                        </tbody>
                      </table>
                    </div>
                  </div>
                </section>
                </div>
              </div>
              <table style="width:100%;margin-bottom:10px"><tr><td align="center"><a href="#" class="btn btn-s-md btn-info" style="background-color:#428bca; border-color:#428bca">保存</a></td></tr></table>
            </aside>
            </section>
          </section>
        </section>

      <aside class="bg-light lter b-l aside-md hide" id="notes">
        <div class="wrapper">Notification</div>
      </aside>
    </section>
  </section>
</section>

</body>
</html>
