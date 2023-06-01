<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Acme&display=swap" rel="stylesheet" />
<title>navbar</title>
</head>
<body>
	<%
		session=request.getSession();
		int user_id = 0;
		if(session.getAttribute("user_id") != null ){
			user_id=(Integer) session.getAttribute("user_id");
		}
	%>
	<header class="nav-header">
		<c:url value="/movie/list" var="main" />
		<h1 class="nav-title"><a href="${main}">MovieStar</a></h1>
		<div class="nav-user">
			<ul>
				<%
					if (user_id == 1){  // 관리자인 경우
				%>
					<c:url value="/movie/register" var="register" />
					<li>
					<a href="${register}" class="user">영화등록</a></li>
					<c:url value="/user/logout" var="logout" />
					<li>
					<a href="${logout}" class="user">로그아웃</a></li>
				<%
					} else if(user_id != 0){  // 일반 회원인 경우
				%>
					<c:url value="/user/mylist?id=${user_id}" var="mylist" />
					<li>
					<a href="${mylist}" class="user">마이페이지</a></li>
					<c:url value="/user/logout" var="logout" />
					<li>
					<a href="${logout}" class="user">로그아웃</a></li>
				<%
					} else{ // 비회원인 경우
				%>
					<c:url value="/user/signin" var="url" />
					<li><a href="${url}" class="user">로그인</a></li>
					<c:url value="/user/signup" var="url2" />
					<li><a href="${url2}" class="user">회원가입</a></li>
				<%
					}
				%>
			</ul>
		</div>
	</header>
</body>
</html>