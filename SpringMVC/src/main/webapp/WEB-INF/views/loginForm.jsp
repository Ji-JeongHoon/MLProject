<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		<img src="./img/logo.png"><br>
		<form action="./loginAction" method="post">
		ID : <input type="text" name="m_id"><br>
		PW : <input type="password" name="m_pw"><br>
		<input type="submit" value="로그인"> 
		<a href="./joinMemberForm">회원 가입</a>
		</form>
	</div>
	
	
	<form action="./testAction" method="post">
	값1 : <input type = "text" name = "first"><br>
	값 2 : <input type = "text" name="second"><br>	
	<input type="submit" value="테스트!!"> 
	</form>
	
	
</body>
</html>

















