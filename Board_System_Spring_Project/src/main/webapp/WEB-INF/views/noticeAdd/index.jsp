<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dlwnsgk's Notice Board</title>
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/noticeAdd/style.css">
</head>
<body>

	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	
	<form id="menuForm"> <!-- will add js code to replace form tag's action -->
	
		<div id="container">
			<div id="menuAdmin">
				<h2 id="menuAdminH2">Write Post</h2>
				<br>
				<label for="memID">User ID</label>
				<input type="text" id="memID" name="memID" placeHolder = "User ID" maxlength="20" value="${username}" readonly style="background-color:#e0e0e0">
				<br>
				<label for="title">Title</label>
				<input type="text" id="title" name="title" placeHolder = "Insert Title" maxlength="15">
				<br>
				<label for="content">Content</label>
				<input type="text" id="content" name="content" placeHolder = "Insert content" maxlength="40">
				<br>
				<label for="writer">Writer</label>
				<input type="text" id="writer" name="writer" placeHolder = "Writer" maxlength="10" value="${writer}" readonly style="background-color:#e0e0e0">
				<br>
				
				<input type="hidden" id="indate" name="indate"> <!-- save the key to use it later -->
				
				<button type="button" id="buttonSubmit">Submit</button> <!-- type="button" to work with js -->
				
				
			</div>
		</div>
		
	</form>
	
	<%@ include file="/WEB-INF/views/default/footer.jsp" %>
	<script src="${pageContext.request.contextPath}/resources/js/noticeAdd/script.js"></script>
</body>
</html>