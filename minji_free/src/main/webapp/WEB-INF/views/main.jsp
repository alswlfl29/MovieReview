<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MovieStar</title>
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="stylesheet" href="../resources/main.css" type="text/css" />
</head>
<body>
	<%@ include file="navbar.jsp"%>
	<div class="title-container">
		<h3 class="title">영화 목록</h3>
		<p class="description">감상하신 영화의 감상평을 남겨주세요.</p>
	</div>
	<div id="container">
		<c:forEach var="movie" items="${movies}">
			<div class="card">
				<img class="img" src="<c:url value='${movie.image}' />" alt="영화" />
				<h2 class="card-title">
					<c:out value="${movie.title}" />
				</h2>
				<div class="card-body">
					<div class="data">
						<span class="date"><c:out value="${movie.open_date}" /></span> <span
							class="card-actor"><c:out value="${movie.actor}" /></span>
					</div>
					<p class="card-text">
						<c:out value="${movie.content}" />
					</p>
					<c:url value="/review/list?id=${movie.movie_id}" var="url" />
					<a href="${url}" class="btn btn--gold">리뷰보러가기</a>
					<c:if test="${user_id eq 1 }"> 
						<div class="btn-wrap" style="justify-content:flex-end;">
							<c:url value="/movie/modify?id=${movie.movie_id}" var="url" />
							<a href="${url}" class="btn btn--brown">정보 수정</a>
						</div>
					</c:if>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>