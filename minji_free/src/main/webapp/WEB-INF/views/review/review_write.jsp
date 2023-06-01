<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="stylesheet" href="../resources/read.css" type="text/css" />
<title>리뷰 등록</title>
</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div align=center>
		<div class="title-container">
			<h3 class="title">영화 리뷰 등록</h3>
		</div>
		<form name=form1 action="http://localhost:8080/free/review/register/"
			method="post">
			<input type="hidden" value="${user_id}" name="user_id" />
			<input type="hidden" value="${param.id}" name="movie_id" />
			<div class="table-wrap" style="padding-bottom:0">
				<table class="read-wrap">
					<tr>
						<th class="read-word">제목</th>
						<td class="read-content"><input type="text" name="title" class="write-title" required /></td>
					</tr>
					<tr>
						<td class="read-content" style="height:500px;" colspan=2>
						<textarea name="content" placeholder="내용을 입력해주세요." class="write-content" required></textarea></td>
					</tr>
				</table>
			</div>
			<div class="btn-wrap" style="padding:20px 0; width:80%; justify-content: flex-end;">
					<input type="reset" name="reset" value="다시 작성" class="btn" />
					<input type="submit" name="submit" value="보내기" class="btn btn--reverse" />
			</div>
		</form>
	</div>
</body>
</html>