<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#wrapper{
		width : 500px;
		height : 800px;
		border : 1px solid black;
		margin : 1px auto;
	
	}


</style>

</head>
<body>

<div id="wrapper">
		<h1>글 쓰기</h1><br>
		<form action="./writeContentAction" method="post">
			작성자 : ${sessionData.m_nickname }<br>
			제목 : <input type="text" name="b_title"><br>
			내용 : <br>
			<textarea rows="20" cols="45" name="b_content">
			</textarea>		
			<br>
			
			<input type="submit" value="글 작성">
		</form>
	</div>

</body>
</html>