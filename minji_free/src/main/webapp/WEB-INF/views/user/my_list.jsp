<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 쓴 리뷰 목록</title>
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="stylesheet" href="../resources/list.css" type="text/css" />
</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div align=center>
		<div class="title-container">
			<h3 class="title">내가 쓴 리뷰</h3>
		</div>
		<div class="goList" style="margin-top:0px">
			<c:url value="/user/modify-title?id=${user_id}" var="url" />
			<a href="${url}" class="btn btn--reverse">리뷰 제목 수정</a><br>
		</div>
		<div class="table-wrap">
			<table>
				<thead>
					<tr>
						<th>NO</th>
						<th>제목</th>
						<th>내용</th>
						<th>작성일</th>
						<th></th>
					</tr>
				</thead>
				<c:forEach var="review" items="${reviews}" varStatus="status">
					<tbody>
						<tr>
							<td><c:out value="${status.count}" /></td>
							<td><p class="table-title"><c:out value="${review.title}" /></p></td>
							<td><p class="content"><c:out value="${review.content}" /></p></td>
							<td>
								<c:set var="date" value="${review.createAt}" />
								<fmt:formatDate value="${date}" pattern="yy-MM-dd" type="date"/>
							</td>
							<td>
								<div class="btn-wrap" style="justify-content:flex-end;">
									<c:url value="/review/read?id=${review.review_id}"
											var="url" /><a href="${url}" class="btn btn--brown">정보 보기</a> 
									<c:if test="${review.user_id eq user_id }">
										<c:url value="/review/modify?id=${review.review_id}" var="url" />
										<a href="${url}" class="btn btn--brown">정보 수정</a>
										<c:url value="/review/delete?id=${review.review_id}" var="url" />
										<a href="${url}" class="btn btn--brown">정보 삭제</a>
									</c:if>
								</div>		
							</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>