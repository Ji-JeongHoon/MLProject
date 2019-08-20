<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<%@ page import="org.zerok.board.domain.BoardVO" %>
<%@ page import="org.ivar.framework.ClassUtil" %>
<%@ page import="org.ivar.framework.DisplayControl" %>

<%@include file="../includes/header.jsp" %>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">게시글 수정</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
					<form id="updateForm" role="form" action="/board/update" method="post">
						<div class="form-group">
							<label>번호</label>
							<input class="form-control" name="id" value="<c:out value="${board.id}" />" readonly=="readonly">
						</div>
						<div class="form-group">
							<label>제목</label>
							<input class="form-control" name="title" value="<c:out value="${board.title}" />" >
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows=3 name="contents" >
								<c:out value="${board.contents}" />
							</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input class="form-control" name="writer" value="<c:out value="${board.writer}" />" readonly="readonly">
						</div>
						<button type="submit" data-oper="update" class="btn btn-default">수정</button>
						<button type="submit" data-oper="delete" class="btn btn-danger">삭제</button>
						
						<button type="submit" data-oper="list" class="btn btn-info">목록 보기</button>

						<!-- Pagination -->						
						<input type="hidden" name="curPage" value="${criteria.curPage}">
						<input type="hidden" name="pageSize" value="${criteria.pageSize}">

						<input type="hidden" name='keyword' value="<c:out value="${criteria.keyword}"></c:out>">
						<input type="hidden" name='type' value="<c:out value="${criteria.type}"></c:out>">
						
					</form>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
<%@include file="../includes/footer.jsp" %>

<script type="text/javascript">
<!--
$(document).ready(function(){
	var updateForm = $("#updateForm");
	
	$("button").on("click", function(e) {
		e.preventDefault();
		
		var oper = $(this).data("oper");
		console.log(oper);
		
		if (oper === 'delete') {
			updateForm.attr("action", "/board/delete");
		} else if (oper === 'list') {
			updateForm.attr("action", "/board/list");
			updateForm.attr("method", "get");
			var curPageTag = $("input[name='curPage']").clone();
			var pageSizeTag = $("input[name='pageSize']").clone();
			var keywordTag = $("input[name='keyword']").clone();
			var typeTag = $("input[name='type']").clone();
			
			updateForm.empty();
			
			updateForm.append(curPageTag);
			updateForm.append(pageSizeTag);
			updateForm.append(keywordTag);
			updateForm.append(typeTag);
		}
		updateForm.submit();
	});

})
//-->
</script>
            