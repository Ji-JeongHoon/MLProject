<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

	<div id="wrapper">
		제목 : ${boardData.boardVO.b_title }<br>
		작성자 : ${boardData.memberVO.m_nickname }<br>
		작성일 : ${boardData.boardVO.b_writedate }<br>
		내용 : <br>
		${boardData.boardVO.b_content }<br><br>
		
		<br>
		<br><br><br> 댓글달기? <br>
		
		<table border="1">
			<tr><td>작성자</td><td>내용</td><td>작성일</td><td>삭제</td></tr>
			<c:forEach var="commentList" items="${commentList }">
				<tr>
					<td>${commentList.m_nickname }</td>
					<td>${commentList.c_comment }</td>
					<td>${commentList.c_writedate }</td>
					<c:if test="${sessionData.sessionIdx == commentList.m_idx }">
						<td><a href="./deleteCommentAction?c_idx=${commentList.c_idx }&b_idx=${commentList.b_idx}">삭제</a></td>
					</c:if>				
				</tr>
			</c:forEach>
		</table>
		
		
		
		
		<br>
		
		<div id = "writeCommentBox">
			<c:if test="${!empty sessionData }">
				<form action = "./writeCommentAction?b_idx=${boardData.boardVO.b_idx}" method="post">
	   				<textarea name="c_comment"></textarea><br>
	   				<input type = "hidden" name="m_idx" value="${sessionData.sessionIdx }">
	   				<input type = "hidden" name="m_nickname" value="${sessionData.sessionNickname }">
	   				<input type="submit" value = "댓글달기"><br><br><br>
	   			</form>
			</c:if>
		</div>
		
		<a href="./boardPage">목록으로</a>
		
		<c:if test="${sessionData.sessionIdx == boardData.boardVO.m_idx }">
			<a href="./deleteContentAction?b_idx=${boardData.boardVO.b_idx }">삭제</a>
			<a href="./updateContentPage?b_idx=${boardData.boardVO.b_idx }">수정</a>
		
		</c:if>
	</div>

