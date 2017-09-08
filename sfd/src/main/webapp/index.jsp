<%@ page import="java.util.List" %>
<%@ page import="sfd.Count" %>
<%@ page import="java.util.ArrayList" %>
<%@page isELIgnored="false" language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html ng-app="myApp" lang="zh-CN">

<head>
    <title>报名页面</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
    <link rel="stylesheet" type="text/css" href="index.css">
    <script src="display.js"></script>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png">
</head>

<body class="wrap">

<div id="full">
    <div class='cont'>
        <form action="/sign-up.do" method="post">
            <table>
                <tr>
                    <td>学号</td>
                    <td><input type="text" readonly name="sid" id="one"></td>
                </tr>
                <tr>
                    <td>姓名</td>
                    <td ><input type="text" readonly name="name" id="two"></td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td ><input type="text" readonly name="email" id="three"></td>
                </tr>
                <tr>
                    <td>学院</td>
                    <td ><input type="text" readonly name="academy" id="four"></td>
                </tr>
                <tr>
                    <td>班级</td>
                    <td ><input type="text" readonly name="classAndGrade" id="five"></td>
                </tr>
                <tr>
                    <td>验证码</td>
                    <td ><input type="text" readonly name="captcha" id="code"></td>
                </tr>

            </table>
            <div class="button">
                <input type="submit" value="确定">
                <input type="button" value="取消" id="obtn1">
            </div>
        </form>
    </div>
</div>

<div class="container">
    <div class="row">
        <header class="status">
            <h2 class="text-center" style="color: blanchedalmond; font-size: 40px;">软件自由日报名</h2><br>
            <img src="http://7xs8o3.com1.z0.glb.clouddn.com/logo.png">
        </header>
    </div>
    <div class="row signup">
        <form method="post" name="form_signup" class="center-block col-xs-12 col-md-4" novalidate style="float:none" action="/sign-up.do">
            <div><img src="http://xiyoulinux.qiniudn.com/xiyoulogo_135.png" alt="logo" class="img-circle">
                <h2 class="sign-header">请填写以下信息</h2></div>
            <div class="input-content">
                <%
                    if(request.getAttribute("error") != null){
                %>
                <div class="error" style="margin-top: 20%">
                <%
                        List<String> errorList = (List<String>) request.getAttribute("error");
                        for(String s : errorList){
                %>
                <p><span style="color: #03ff05">[! <%=s%> !]</span></p>
                <%
                        }
                %>
                    </div>
                <%
                    }
                %>
                <%
                    if(request.getAttribute("sno") != null && ((String)request.getAttribute("sno")).trim().length() != 0){
                %>
                <div class="sid">
                    <label name="sid">学号</label>
                    <input type="text" value='<%=(String)request.getAttribute("sno")%>' class="form-control" name="sid" required placeholder="学号"></div>
                <%
                    }else {
                %>
                <div class="sid">
                    <label name="sid">学号</label>
                    <input type="text" class="form-control" name="sid" required placeholder="学号" ></div>
                <%
                    }
                %>
                <%
                    if(request.getAttribute("name") != null && ((String)request.getAttribute("name")).trim().length() != 0){
                %>
                <div class="name">
                    <label name="name">姓名</label>
                    <input type="text" value='<%=(String)request.getAttribute("name")%>' class="form-control" name="name"  required placeholder="姓名" ></div>
                <%
                }else {
                %>
                <div class="name">
                    <label name="name">姓名</label>
                    <input type="text" class="form-control" name="name" required placeholder="姓名" ng-focus></div>
                <%
                    }
                %>
                <%
                    if(request.getAttribute("email") != null && ((String)request.getAttribute("email")).trim().length() != 0){
                %>
                <div class="email">
                    <label name="email">邮箱</label>
                    <input type="text" value='<%=(String)request.getAttribute("email")%>' class="form-control" name="email" required placeholder="邮箱" ng-focus></div>
                <%
                }else {
                %>
                <div class="email">
                    <label name="email">邮箱</label>
                    <input type="text" class="form-control" name="email"  required placeholder="邮箱" ng-focus></div>
                <%
                    }
                %>

                <%
                    if(request.getAttribute("academy") != null && ((String)request.getAttribute("academy")).trim().length() != 0){
                %>
                <div class="academy">
                    <label name="academy">学院</label>
                    <select class="form-control" name="academy">
                        <option value="通信与信息工程学院" selected>通信与信息工程学院
                        <option value="电子工程学院">电子工程学院
                        <option value="计算机学院">计算机学院
                        <option value="自动化学院">自动化学院
                        <option value="经济与管理学院">经济与管理学院
                        <option value="理学院">理学院
                        <option value="人文社科学院">人文社科学院
                        <option value="外国语学院">外国语学院
                        <option value="数字艺术学院">数字艺术学院
                    </select>
                </div>
                <%
                }else {
                %>
                    <div class="academy">
                        <label name="academy">学院</label>
                        <select class="form-control" name="academy">
                            <option value="通信与信息工程学院" selected>通信与信息工程学院
                            <option value="电子工程学院">电子工程学院
                            <option value="计算机学院">计算机学院
                            <option value="自动化学院">自动化学院
                            <option value="经济与管理学院">经济与管理学院
                            <option value="理学院">理学院
                            <option value="人文社科学院">人文社科学院
                            <option value="外国语学院">外国语学院
                            <option value="数字艺术学院">数字艺术学院
                        </select>
                    </div>
                <%
                    }
                %>

                <%
                    if(request.getAttribute("classAndGrade") != null && ((String)request.getAttribute("classAndGrade")).trim().length() != 0){
                %>
                <div class="classAndGrade">
                    <label name="classAndGrade">班级</label>
                    <input type="text" value='<%=(String)request.getAttribute("classAndGrade")%>' class="form-control" name="classAndGrade" required placeholder="班级(如: 计科1701)" ng-focus></div>
                <%
                }else {
                %>
                <div class="classAndGrade">
                    <label name="classAndGrade">班级</label>
                    <input type="text" class="form-control" name="classAndGrade" required placeholder="班级(如: 计科1701)" ng-focus></div>
                <%
                    }
                %>




                <div class="captcha">
                    <label name="captcha">验证码&nbsp;&nbsp;&nbsp;</label><img width="80px" height="30px" src="./image.do">
                    <input type="text" class="form-control" name="captcha"/>
                </div>
                <input type="button" class="btn btn-primary btn-lg btn-block" value="Submit" id="obtn2"><br>
                <h2 style="text-align:center; color: white;">当前已报名：<span style="color: red; font-size: 30px"><%= Count.getCount()%></span></h2>
            </div>
        </form>
    </div>
    <script src="http://cdn.bootcss.com/jquery/3.0.0-beta1/jquery.js"></script>
    <script src="http://cdn.bootcss.com/angular.js/1.5.0/angular.min.js"></script>
    <script type="text/javascript" src="app.js"></script>
</div>
</body>
</html>
