<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resources/common.css" type="text/css" />
<link rel="stylesheet" href="../resources/read.css" type="text/css" />
<title>영화 등록</title>
</head>
<body>
	<%@ include file="../navbar.jsp"%>
	<div align=center>
		<div class="title-container">
			<h3 class="title">영화 등록</h3>
		</div>
		<form name=form1 action="http://localhost:8080/free/movie/register/"
			method="post">
			<div class="table-wrap" style="padding-bottom:0">
				<table class="read-wrap">
					<tr>
						<th class="read-word">제목</th>
						<td class="read-content"><input type="text" name="title" placeholder="영화제목을 입력하세요" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
					<tr>
						<th class="read-word">Poster</th>
						<td class="read-content"><input type="text" name="image" placeholder="포스터 URL을 입력하세요" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
					<tr>
						<th class="read-word">배우</th>
						<td class="read-content"><input type="text" name="actor" placeholder="배우를 입력하세요" class="write-title" style="font-size: 13px;" required /></td>
					</tr>
					<tr>
						<th class="read-word">줄거리</th>
						<td class="read-content" style="height:200px;"><textarea name="content" placeholder="줄거리를 입력하세요" class="write-content" style="padding:20px 10px" required></textarea></td>
					</tr>
					<tr>
						<th class="read-word">개봉일</th>
						<td class="read-content"><input type="text" name="open_date" placeholder="개봉일을 입력하세요" class="write-title" style="font-size: 13px;" required /></td>
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