<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="wrapper">
		제목 : ${boardData.contentVO.c_title }<br>
		작성자 : ${boardData.memberVO.m_nick }<br>
		작성일 : ${boardData.contentVO.c_writedate }<br>
		내용 : <br>
		${boardData.contentVO.c_content }<br><br>
		
		<c:forEach var = "file" items="${boardData.fileList}">
			<img src="${file.f_linkname}"><br>
		
		
		</c:forEach>
		
		<br>
		<br>
		
		<a href="./boardPage">목록으로</a>
		
		<c:if test="${sessionData.m_idx == boardData.contentVO.m_idx }">
			<a href="./deleteContentAction?c_idx=${boardData.contentVO.c_idx }">삭제</a>
			<a href="./updateContentForm?c_idx=${boardData.contentVO.c_idx }">수정</a>
		</c:if>
			
	</div>
</body>
</html>
















