<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link  rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/login/style.css"/>
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	<div id="login_container_wrapper">
		<div id="login_container">
			<h2>
				Login
			</h2>
			
			<!-- login failure message -->
			<c:if test="${not empty param.error}">
				<p style="color:red;">Wrong Username or Password</p>
			</c:if>
			
			<form action="${pageContext.request.contextPath}/login" method="post">
				<!-- CSRF token added -->
				<input type="hidden" name="_csrf" value="${_csrf.token}"/>
				
				<div class="input_group">
					<label for="username">Username</label>
					<input type="text" id="username" name="username" required/>
				</div>
				
				<div class="input_group">
					<label for="password">Password</label>
					<input type="password" id="password" name="password" required/>
				</div>
				
				<button type="submit" id="login_button">Login</button>
			</form>
			<div id="register_link">
				<a href="${pageContext.request.contextPath}/registerPage">Register</a>
			</div>
		</div>
	</div>
	
	<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>