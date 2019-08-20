<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
	#wrapper{
		width : 800px;
		margin : 1px auto;
		border : 1px solid black;
	
	
	}



</style>

</head>
<body>
<div id="wrapper">
 		<div id = "box1">
            <table border="1">
			<tr><td>글 번호</td><td>제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr>
			<c:forEach var="boardData" items="${boardDataList }">
				<tr>
					<td>${boardData.boardVO.b_idx }</td>
					<td><a href ="./readContentPage?b_idx=${boardData.boardVO.b_idx }">${boardData.boardVO.b_title }</a></td>
					<td>${boardData.memberVO.m_nickname }</td>
					<td>${boardData.boardVO.b_count }</td>
					<td>${boardData.boardVO.b_writedate }</td>			
				</tr>
			</c:forEach>
			</table>
         </div>
         
         <!--<c:if test="${!empty sessionData }"> </c:if>-->
			<a href="./writeContentPage">글 작성</a>
			
		<!-- 검색 부분 -->	
			<br><br>
			
			<form action="./boardPage" method="get">
			<select name="searchTarget">
				<option value="b_title" selected>제목</option>
				<option value="b_content">내용</option>
				<option value="m_nickname">닉네임</option>
			</select>
			
			
			검색 : <input type="text" name="searchWord">
			<input type="submit" value="검색">
			
		</form>
		
</div>
</body>
</html>