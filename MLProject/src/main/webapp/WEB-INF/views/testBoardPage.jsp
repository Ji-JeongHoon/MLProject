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

</body>
</html>