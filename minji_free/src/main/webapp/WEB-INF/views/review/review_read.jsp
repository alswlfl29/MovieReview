<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="stylesheet" href="../resources/read.css" type="text/css" />
<title>리뷰 상세 정보</title>
</head>
<body>
	<%@ include file="../navbar.jsp" %>
	<div align=center>
		<div class="title-container">
			<h3 class="title">리뷰 정보</h3>
		</div>
		<div class="goList">
			<c:url value="/review/list?id=${review.movie_id}" var="url"/><a href="${url}" class="btn btn--reverse">목록 보기</a>
		</div>
		<div class="table-wrap">
			<table class="read-wrap">
				<tr class="read-first">
					<th class="read-word">작성자</th>
						<td class="read-content" style="width:60%;"><c:out value="${review.nickname}"/></td>
					<th class="read-word">작성일</th>
						<td class="read-content" style="text-align:center">
							<c:set var="date" value="${review.createAt}" />
							<fmt:formatDate value="${date}" pattern="yy-MM-dd" type="date" />
						</td>
				</tr>
				<tr><th class="read-word">제목</th><td class="read-content" colspan='3'><c:out value="${review.title}"/></td></tr>
				<tr><td class="read-content" style="height:500px;" colspan='4'><c:out value="${review.content}"/></td></tr>
			</table>
		</div>
		<div class="btn-wrap" style="padding:20px 0; width:80%; justify-content: flex-end;">
			<c:if test="${review.user_id eq user_id }">
				<c:url value="/review/modify?id=${review.review_id}" var="url" />
				<a href="${url}" class="btn btn--brown">정보 수정</a>
				<c:url value="/review/delete?id=${review.review_id}" var="url" />
				<a href="${url}" class="btn btn--brown">정보 삭제</a>
			</c:if>
		</div>
	</div>
</body>
</html>