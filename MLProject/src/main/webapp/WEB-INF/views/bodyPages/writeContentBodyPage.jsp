<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="wrapper">
	<h1>글 쓰기</h1><br>
	<form action="./writeContentAction" method="post">
		작성자 : ${sessionData.sessionNickname }<br>
		제목 : <input type="text" name="b_title"><br>
		내용 : <br>
		<textarea rows="20" cols="45" name="b_content">
		</textarea>		
		<br>
		<input type = "hidden" value="${sessionData.sessionIdx }" name="m_idx">
		<input type="submit" value="글 작성">
	</form>
</div>
