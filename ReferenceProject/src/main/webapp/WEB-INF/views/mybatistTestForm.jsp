<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

mybatis test form <br>

<form action = "./mybatisJoinMemberAction" method="post">
 ID : <input type="text" name="m_id"><br>
 PW : <input type="password" name = "m_pw"><br>
 Nick : <input type = "text" name = "m_nick"><br>
 phone : <input type = "text" name = "m_phone"><br>
 address : <input type = "text" name = "m_address"><br>
 <input type="submit" value ="회원가입">



</form>



</body>
</html>


