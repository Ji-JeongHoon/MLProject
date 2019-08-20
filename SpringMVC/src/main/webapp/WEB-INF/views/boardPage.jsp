<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>


</head>
<body>
	<div id="wrapper">
		<c:choose>
			<c:when test="${!empty sessionData }">
				${sessionData.m_nick }님 환영합니다.
				<a href="./logoutAction">로그아웃</a><br>
			</c:when>
			<c:otherwise>
				비회원으로 로그인 하였습니다.
				<a href="./loginForm">로그인 페이지로</a><br>
			</c:otherwise>
		</c:choose>
	
		<table border="1">
			<tr><td>글 번호</td><td>제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr>
			<c:forEach var="boardData" items="${boardDataList }">
				<tr>
					<td>${boardData.contentVO.c_idx }</td>
					<td><a href="./readContentPage?c_idx=${boardData.contentVO.c_idx }">${boardData.contentVO.c_title }</a></td>
					<td>${boardData.memberVO.m_nick }</td>
					<td>${boardData.contentVO.c_count }</td>
					<td>${boardData.contentVO.c_writedate }</td>				
				</tr>
			</c:forEach>
		</table>
		
		<br>
		
		<c:if test="${!empty sessionData }">
			<a href="./writeContentForm">글 작성</a>
		</c:if>
		
		<br>
		
		<form action="./boardPage" method="get">
			
			<select name="searchTarget">
				<option value="c_title" selected>제목</option>
				<option value="c_content">내용</option>
			</select>
			
			
			검색 : <input type="text" name="searchWord">
			<input type="submit" value="검색">
			
		</form>
			
	</div>
	
	
	<script >
		var now = new Date();
		document.write(now);
	 	
		 
	</script>

	


</body>
</html>














