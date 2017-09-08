<%--
  Created by IntelliJ IDEA.
  User: zhuxinquan
  Date: 16-9-1
  Time: 下午3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset= "utf8">
    <title>抽奖页面</title>
    <style>
        html{
            height: 100%;
        }
        body{
            margin: 0;
            padding: 0;
            /*background: url("http://7xs8o3.com1.z0.glb.clouddn.com/main-bg-compressor.jpg") no-repeat;*/
            background: url(http://7xs8o3.com1.z0.glb.clouddn.com/b3.jpg) no-repeat;
            background-size: cover;
            z-index: -999;
            background-position: center center;
        }
        .num-box{
            width:1200px;
            height: 265px;
            margin: 50px auto;
            overflow: hidden;
        }
        .num{
            width: 148px;
            background-image:-webkit-linear-gradient(to top, #FF9500, #FFD191);
            background-image: linear-gradient(to top,#FF9500, #FFD191);
            height: 100%;
            float: left;
            border-left: #666 solid 2px;
            border-radius: 10px;
        }
        .number{
            background: url("images/num.png");
            width: 100%;
            height: 100%;
        }
        .button{
            width: 300px;
            margin: 50px  auto;
        }
        #btn{
            background-color: #00375B;
            width: 300px;
            height: 80px;
            border:none;
            border-radius: 5px;
            color:#fff;
            font-size: 40px;
        }
        .info{
            width: 1200px;
            height: 100px;
            line-height: 100px;
            margin: 0 auto;
            text-align: center;
            font-size: 80px;
            color: #FFF;
        }
        #name{
            color: #15ff00;
        }
    </style>
    <link rel="shortcut icon" type="image/x-icon" href="http://7xs8o3.com1.z0.glb.clouddn.com/sign1.png">
    <script src="http://cdn.bootcss.com/jquery/2.2.1/jquery.min.js"></script>
    <%--<script type="text/javascript" src="http://gsgd.co.uk/sandbox/jquery/easing/jquery.easing.1.3.js"></script>--%>
    <script type="text/javascript" src="./js/easing.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="index.css">--%>
</head>
<body class="wrap">
<div class="num-box">
    <div class="num">
        <div class="number">
        </div>
    </div>
    <div class="num">
        <div class="number">
        </div></div>
    <div class="num">
        <div class="number">
        </div></div>
    <div class="num">
        <div class="number">
        </div></div>
    <div class="num">
        <div class="number">
        </div></div>
    <div class="num">
        <div class="number">
        </div></div>
    <div class="num">
        <div class="number">
        </div></div>
    <div class="num">
        <div class="number">
        </div></div>
</div>
<div>
    <p class="info"></p>
</div>
<div class="button">
    <button id="btn">
        开始抽奖
    </button><br>
</div>
<div style="magin:0 auto; text-align: center">
    <a href="LuckList.jsp" target="_self" style="text-decoration:none;">
        <span style="color:#a38153;">幸运名单</span>
    </a>
</div>
<script type="text/javascript" src="./js/app.js"></script>
</body>
</html>