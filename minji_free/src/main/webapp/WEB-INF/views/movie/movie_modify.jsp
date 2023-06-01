<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="stylesheet" href="../resources/read.css" type="text/css" />
<title>영화 수정</title>
</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div align=center>
		<div class="title-container">
			<h3 class="title">영화 수정</h3>
		</div>
		<form name=form1 action="http://localhost:8080/free/movie/modify/"
			method="post">
			<input type="hidden" name="movie_id" value="${movie.movie_id}" />
			<div class="table-wrap" style="padding-bottom:0">
				<table class="read-wrap">
					<tr>
						<th class="read-word">제목</th>
						<td class="read-content"><input type="text" value="${movie.title}" name="title" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
					<tr>
						<th class="read-word">Poster</th>
						<td class="read-content"><input type="text" value="${movie.image}" name="image" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
					<tr>
						<th class="read-word">배우</th>
						<td class="read-content"><input type="text" value="${movie.actor}" name="actor" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
					<tr>
						<th class="read-word">줄거리</th>
						<td class="read-content" style="height:200px;"><textarea name="content" class="write-content" style="padding:20px 10px" required>${movie.content}</textarea></td>
					</tr>
					<tr>
						<th class="read-word">개봉일</th>
						<td class="read-content"><input type="text" name="open_date" value="${movie.open_date}" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
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