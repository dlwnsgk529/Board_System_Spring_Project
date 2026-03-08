<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="_csrf" content="${_csrf.token}"> <!-- token sent to script.js + automatically sent to controller by Spring Boot -->
<meta name="_csrf_header" content="${_csrf.headerName}">
<title>Dlwnsgk's Board System</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
	
	<%@ include file="/WEB-INF/views/default/header.jsp"%>

	<div id="container">
		<div id="menuAdmin">
			<h2 id="menuAdminH2">
				Notice Board
			</h2>
			<!-- Use Jstl library to set condition on session's variables -->
			<!-- Show button if isManager in session is true -->
			<c:if test = "${MANAGER == true}">
				<button id="createButton" type="button" onclick="location.href = '${pageContext.request.contextPath}/noticeAddPage'">Create</button>
			</c:if>
			<div id="menuList">
			</div>
		</div>
	</div> 
	
	<%@ include file="/WEB-INF/views/default/footer.jsp"%>
	
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/script.js"></script>
</body>
</html>