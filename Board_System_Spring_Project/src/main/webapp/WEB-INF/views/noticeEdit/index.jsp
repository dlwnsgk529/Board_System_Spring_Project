<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>Notice Edit Page</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/noticeEdit/style.css"/>

</head>
<body>

	<%@ include file="/WEB-INF/views/default/header.jsp" %>
	
	<form id="menuForm"> <!-- will add js code to replace form tag's action -->
	
		<div id="container">
			<div id="menuAdmin">
				<h2 id="menuAdminH2">Notice</h2>
				<input type="hidden" id="idx" name="idx" placeHolder = "idx" maxlength="20" value="${menu.idx}" readonly>
				
				<br>
				<label for="memID">User ID</label>
				<input type="text" id="memID" name="memID" placeHolder = "User ID" maxlength="20" value="${menu.memID}" readonly style="background-color:#e0e0e0">
				<br>
				<label for="title">Title</label>
				<input type="text" id="title" name="title" placeHolder = "Title" maxlength="15" value="${menu.title}">
				<br>
				<label for="content">Content</label>
				<input type="text" id="content" name="content" placeHolder = "Content" maxlength="40" value="${menu.content}">
				<br>
				<label for="writer">Writer</label>
				<input type="text" id="writer" name="writer" placeHolder = "Writer" maxlength="10" value="${menu.writer}" readonly style="background-color:#e0e0e0">
				<br>
				
				<div id="buttonContainer">
					<c:if test='${MANAGER==true}'>
						<button type="button" id="buttonSave">Save Post</button>
					</c:if>
				</div>

				
			</div>
		</div>
		
	</form>
	
	<%@ include file="/WEB-INF/views/default/footer.jsp" %>
	<script src="${pageContext.request.contextPath}/resources/js/noticeEdit/script.js"></script>

</body>
</html>