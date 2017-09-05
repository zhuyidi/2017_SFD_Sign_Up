<%@ page import="java.sql.Connection" %>
<%@ page import="sfd.DBUtils" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-9-13
  Time: 上午8:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>幸运名单</title>
    <link rel="shortcut icon" type="image/x-icon" href="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png">
    <link rel="stylesheet" type="text/css" href="index.css">

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <style type="text/css">
        html{
            height: 100%;
        }
        body{
            margin: 0;
            padding: 0;
            background: url("http://7xs8o3.com1.z0.glb.clouddn.com/main-bg-compressor.jpg") no-repeat;
            background-size: cover;
            z-index: -999;
            background-position: center center;
        }
        *{
            margin:0px;
            padding:0px;

        }

        th{
            text-align: center;
        }
    </style>
</head>
<body class="wrap">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12">
            <h2>
                <img src="http://7xs8o3.com1.z0.glb.clouddn.com/title.png" alt="标题" style="display: block; margin: 0 auto; width: 300px;">
            </h2>
        </div>
    </div>
    <div id="table1">
        <div class="col-md-6 col-md-offset-3" style="margin-left: 10%; width: 80%;">
            <table class="table table-bordered table-hover table-condensed" style="text-align: center; margin-top: 5%">
                <thead>
                <tr style="font-size:20px;">
                    <th>
                        编号
                    </th>
                    <th>
                        学号
                    </th>
                    <th>
                        姓名
                    </th>
                </tr>
                </thead>
                <tbody>
                <%
                    Connection conn = DBUtils.getConnection();
                    String sql = "select * from userinfo where lottery_flag = 1";
                    Statement stat = conn.createStatement();
                    ResultSet rs = stat.executeQuery(sql);
                    int i = 1;
                    while(rs.next()){
                        int color = i % 2;
                        String css = "";
                        switch(color){
//                            case 0: css = "success"; break;
                            case 0: css = "info"; break;
                            case 1: css = "warning"; break;
                        }
                %>
                <tr class="<%= css %>" style="font-size: 30px;">
                    <td><%= i++ %></td>
                    <td><%= rs.getString("sno") %></td>
                    <td><%= rs.getString("name") %></td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
