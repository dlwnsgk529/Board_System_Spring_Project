<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/register/style.css" />
</head>
<body>
	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	
	<div id="register_container_wrapper">
		<div id="register_container">
			<h2>Register</h2>
			<form action="${pageContext.request.contextPath}/register" method="POST">
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
				<div class="input_group">
					<label for="writer">Writer</label>
					<input type="text" id="writer" name="writer" required/>
				</div>
				
				<div class="input_group">
					<button type="submit" id="register_button">Register</button>
				</div>
				
				<div id="login_link">
					<a href="${pageContext.request.contextPath}/loginPage">Login with my Account</a>
				</div>
				
			</form>
		</div>
	</div>
	
	
	<%@ include file="/WEB-INF/views/default/footer.jsp" %>
</body>
</html>