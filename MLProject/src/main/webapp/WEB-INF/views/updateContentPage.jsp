<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id = "wrapper">
		<form action = "./updateContentAction" method="post">
			작성자 : ${boardData.memberVO.m_nickname }<br>
			제목 : <input type="text" name="c_title" value="${boardData.boardVO.b_title }"> <br>
			내용  : <br>
			<textarea rows="10" cols="45" name="c_content">${boardData.boardVO.b_content }</textarea>
			<input type="hidden" name="c_idx" value="${boardData.boardVO.b_idx }">
			<input type="submit" value= "수정">
		</form>
	</div>

</body>
</html>