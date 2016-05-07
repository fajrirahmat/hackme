<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/libs/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/bootstrap.min.js"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/angular.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/libs/angular-ui-router.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/InvoiceService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/PostingService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/PostingCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/InvoiceCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/index.js"></script>
 --%><link href="${pageContext.request.contextPath}/resources/css/hackme.css" rel="stylesheet">
<title>HackMe</title>
</head>
<body>
	<div class="container">
            <div class="header">
                <div class="row">
                    <div class="col-md-9">
                        <h2><code style="background-color: white;">&lt;HackMe/&gt;</code></h2>
                        <small>Learn Security from Coding</small>
                    </div>
                    <div class="col-md-3">
                        <div class="row profile">
                            <div class="col-md-8 profile-name">{{name}}</div>
                            <div class="col-md-3 profile-foto"><img src="${pageContext.request.contextPath}/resources/images/dummy_profpic.jpg" width="60px" height="60px" alt="profile" /></div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="content row">
                <div class="col-md-2 menu">
                    <ul class="pager">
                        <li><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/insecureinvoice/getAll">Invoice</a></li>
                        <li><a href="${pageContext.request.contextPath}/">Account</a></li>
                        <li><a href="${pageContext.request.contextPath}/#/settings">Settings</a></li>
                        <li><a href="${pageContext.request.contextPath}/logout.html">Logout</a></li>
                    </ul>
                </div>
                <div class="col-md-8">
                	<div class="panel panel-primary">
                		<div class="panel-heading">
                			Invoice
                		</div>
                		<div class="panel-body">
                			<div class="row panel panel-info">
					    		<div class="panel-body"">
					                <div class="col-md-3"><b>No.Faktur</b></div>
					                <div class="col-md-3"><b>Tanggal</b></div>
					                <div class="col-md-3"><b>Dari/Kepada</b></div>
					                <div class="col-md-3"><b>Update Terakhir</b></div>
					            </div>
					    	</div>
					    	<c:if test="${not empty invoices}">
					    		<% int index = 0; %>
							   	<c:forEach var="item" items="${invoices}">
							   		<% index++; %>
							   		<div class="row panel panel-info">
							            <div class="panel-body hover" data-toggle="collapse" href="#demo-<%=index %>">
							                <div class="col-md-3">${item.noFaktur}</div>
							                <div class="col-md-3">${item.tglFaktur}</div>
							                <div class="col-md-3">${item.dariKepada}</div>
							                <div class="col-md-3">${item.lastUpdate}</div>
							            </div>
							            <div id="demo-<%=index %>" class="collapse">
							            	<table style="margin-left: 10px;">
							            		<tr>
							            			<td><b>Keterangan</b></td>
							            			<td>: ${item.keterangan}</td>
							            		</tr>
							            		<tr>
							            			<td><b>User Terakhir</b></td>
							            			<td>: ${item.lastUser}</td>
							            		</tr>
							            	</table>
							                <table class="table table-striped table-bordered table-hover">
							                	<thead>
									              <tr>
									                <th>#</th>
									                <th>ID.Item</th>
									                <th>Nama Perkiraan</th>
									                <th>Debit</th>
									                <th>Kredit</th>
									                <th>Uraian</th>
									              </tr>
									            </thead>
									            <tbody>
									            	<tr>
									            		<td colspan="6" style="text-align: center;" ><code>No Item Found</code></td>
									            	</tr>
									            </tbody>
							                </table>
							            </div>
        </div>
							 	</c:forEach>
							 </c:if>
							<%-- <table class="table table-striped table-bordered table-hover table-condensed" id="invoice-table">
							    <thead>
							      <tr>
							        <th>#</th>
							        <th>No.Faktur</th>
							        <th>Tanggal Faktur</th>
							        <th>Dari/Kepada</th>
							        <th>Keterangan</th>
							        <th>Last User</th>
							        <th>Last Update</th>
							      </tr>
							    </thead>
							    <tbody>
							    	<c:if test="${not empty invoices}">
							    		
							    		<c:forEach var="invoice" items="${invoices}">
							    			<tr>
							    				<td></td>
							    				<td>${invoice.noFaktur }</td>
							    				<td>${invoice.tglFaktur }</td>
							    				<td>${invoice.dariKepada }</td>
							    				<td>${invoice.keterangan }</td>
							    				<td>${invoice.lastUser }</td>
							    				<td>${invoice.lastUpdate }</td>
							    			</tr>
							    		</c:forEach>
							    	</c:if>
							    </tbody>
							</table> --%>
						</div>
						<div class="panel-footer">
							<button class="btn btn-primary" onclick="goToAddInvoice()">Add</button>
							<script>
								var goToAddInvoice = function(){
									window.location = "${pageContext.request.contextPath}/#/invoie/create";
								};
							</script>
						</div>
					</div>
                </div>
            </div>
            <div class="footer" style="text-align: center;border-top: 1px solid #eee;padding-top:10px;color:#ede;">
            	Copyright Sinau Academy
            </div>
        </div>
	
</body>
</html>