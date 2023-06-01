<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${contextPath}/resources/auth.css" type="text/css" />
<link rel="stylesheet" href="${contextPath}/resources/common.css" type="text/css" />
<title>로그인</title>

</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div class="container">
		<div class="wrapper">
			<h2>로그인</h2>
			<form method="post" action="http://localhost:8080/free/user/signin/" id="auth">
				<input type="text" name="email" placeholder="email" maxlength="20" required />
				<input type="password" name="passwd" placeholder="password" maxlength="20" required />
				<c:if test="${param.message eq 'error' }">
					<div style="color:red;">아이디 또는 비밀번호가 일치하지 않습니다.</div>
				</c:if>
				<input type="submit" value="로그인" />
			</form>	
		</div>
	</div>
</body>
</html>