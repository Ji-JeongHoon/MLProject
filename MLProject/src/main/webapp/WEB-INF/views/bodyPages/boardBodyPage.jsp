<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <table class="table">
			<tr>
			<th scope="col">글 번호</th>
			<th scope="col">제목</th>
			<th scope="col">작성자</th>
			<th scope="col">조회수</th>
			<th scope="col">작성일</th>
			</tr>
			<c:forEach var="boardData" items="${boardDataList }">
				<tr>
					<th scope="row">${boardData.boardVO.b_idx }</th>
					<td><a href ="./readContentPage?b_idx=${boardData.boardVO.b_idx }">${boardData.boardVO.b_title }</a></td>
					<td>${boardData.memberVO.m_nickname }</td>
					<td>${boardData.boardVO.b_count }</td>
					<td>${boardData.boardVO.b_writedate }</td>			
				</tr>
			</c:forEach>
			</table>
			
	<div>
 		<ul>
  		<c:if test="${pageMaker.prev}">
  		 <li><a href="boardPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
  		</c:if> 
  
 		 <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
 		    <li><a href="boardPage${pageMaker.makeQuery(idx)}">${idx}</a></li>
		  </c:forEach>
    
 		 <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
 		  <li><a href="boardPage${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
 			 </c:if> 
 		</ul>
	</div>
			
         
         <c:if test="${!empty sessionData }"> 
			<a href="./writeContentPage">글 작성</a>
		</c:if>
			
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
		
		
		