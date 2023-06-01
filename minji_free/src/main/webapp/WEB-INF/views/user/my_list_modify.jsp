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
		<form name=form1 action="http://localhost:8080/free/user/modify-title/"
			method="post">
			<div class="table-wrap">
				<table>
					<thead>
						<tr>
							<th>NO</th>
							<th style="width: 45%;">제목</th>
							<th style="width: 35%;">내용</th>
							<th style="width: 20%;">작성일</th>
							
						</tr>
					</thead>
					<c:forEach var="review" items="${reviews}" varStatus="status">
						<tbody>
							<tr>
								<td><c:out value="${status.count}" /></td>
								<td><input type="text" name="title_${review.review_id}" value="${review.title}" class="write-title" required /></td>
								<td><p class="content" style="width: 250px;"><c:out value="${review.content}" /></p></td>
								<td>
									<c:set var="date" value="${review.createAt}" />
									<fmt:formatDate value="${date}" pattern="yy-MM-dd" type="date"/>
								</td>
							</tr>
						</tbody>
						<input type="hidden" name="review_id" value="${review.review_id}" />
						<input type="hidden" name="user_id" value="${review.user_id}" />
					</c:forEach>
				</table>
			</div>
			<div class="btn-wrap" style="padding:20px 0; width:80%; justify-content: flex-end;">
				<input type="reset" name="reset" value="다시작성" class="btn">	
				<input type="submit" name="submit" value="최종 수정" class="btn btn--reverse">
			</div>
		</form>
	</div>
</body>
</html>