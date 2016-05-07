<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<title>Hackme</title>
</head>
<body>
	<div>
		<div class="jumbotron">
			<div class="container">
			</div>
		</div>
	</div>
	<div class="container" >
		<c:if test="${reply != null}">
			<div style="color:red;">
				${reply.message}
			</div>
		</c:if>
		<form:form modelAttribute="login" action="${pageContext.request.contextPath}/login">
			<form:input path="username" cssClass="" />
			<form:password path="password" cssClass="" />
			<input class="btn btn-primary" type="submit" value="Login" >
		</form:form>
	</div>
</body>
</html>