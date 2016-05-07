<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/js/libs/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/libs/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/libs/angular.min.js"></script>
<script type="text/javascript" src="resources/js/libs/angular-ui-router.min.js"></script>
<script src="resources/js/services/InvoiceService.js"></script>
<script src="resources/js/services/PostingService.js"></script>
<script src="resources/js/controller/CreateInvoiceCtrl.js"></script>
<script src="resources/js/controller/PostingCtrl.js"></script>
<script src="resources/js/controller/InvoiceCtrl.js"></script>
<script src="resources/js/index.js"></script>
<link href="resources/css/hackme.css" rel="stylesheet">
<title>HackMe</title>
</head>
<body ng-app="app">
	<div class="container"  ng-controller="mainCtrl">
            <div class="header">
                <div class="row">
                    <div class="col-md-8">
                        <h2><code style="background-color: white;">&lt;HackMe/&gt;</code></h2>
                        <small>Learn Security from Coding</small>
                    </div>
                    <div class="col-md-4">
                        <div class="row profile">
                            <div class="col-md-8 profile-name"><h4>{{name}}</h4></div>
                            <div class="col-md-3 profile-foto"><img src="resources/images/dummy_profpic.jpg" width="60px" height="60px" alt="profile" /></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content row">
                <div class="col-md-2 menu">
                    <ul class="pager">
                        <li><a href="#">Home</a></li>
                        <li><a href="insecureinvoice/getAll">Invoice</a></li>
                        <li><a href="#">Account</a></li>
                        <li><a href="#/settings">Settings</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout.html">Logout</a></li>
                    </ul>
                </div>
                <div class="col-md-8">
                	<ui-view></ui-view>
                </div>
            </div>
            <div class="footer" style="text-align: center;border-top: 1px solid #eee;padding-top:10px;color:#ede;">
            	Copyright Sinau Academy
            </div>
        </div>
	
</body>
</html>