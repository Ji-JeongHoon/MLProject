<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
#wrapper{

		width : 800px;
		height : 800px;
		border : 1px solid black;
		margin : 1px auto;
}
</style>
<body>
		<div id="wrapper">
		제목 : ${boardData.boardVO.b_title }<br>
		작성자 : ${boardData.memberVO.m_nickname }<br>
		작성일 : ${boardData.boardVO.b_writedate }<br>
		내용 : <br>
		${boardData.boardVO.b_content }<br><br>
		
		
		
		<br>
		<br>
		
		<a href="./boardPage">목록으로</a>
		
		<!--<c:if test="${sessionData.m_idx == boardData.boardVO.m_idx }"></c:if>-->
			<a href="./deleteContentAction?b_idx=${boardData.boardVO.b_idx }">삭제</a>
			<a href="./updateContentPage?b_idx=${boardData.boardVO.b_idx }">수정</a>
		
			
	</div>

</body>
</html>