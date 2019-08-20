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
                        <div class="panel-heading">
                            Board List Page
<form id='activeForm' action="/board/list" method="get">
	<select name='type'>
		<option value="" <c:out value="${pageMaker.criteria.type == null ? 'selected' : '' }"></c:out> >--</option>
		<option value="T" <c:out value="${pageMaker.criteria.type eq 'T' ? 'selected' : '' }"></c:out>>제목</option>
		<option value="C" <c:out value="${pageMaker.criteria.type eq 'C' ? 'selected' : '' }"></c:out>>내용</option>
		<option value="W" <c:out value="${pageMaker.criteria.type eq 'W' ? 'selected' : '' }"></c:out>>작성자</option>
		<option value="TC" <c:out value="${pageMaker.criteria.type eq 'TC' ? 'selected' : '' }"></c:out>>제목 또는 내용</option>
		<option value="TW" <c:out value="${pageMaker.criteria.type eq 'TW' ? 'selected' : '' }"></c:out>>제목 또는 작성자</option>
		<option value="TCW" <c:out value="${pageMaker.criteria.type eq 'TCW' ? 'selected' : '' }"></c:out>>제목, 내용 또는 작성자</option>
	</select>
	<input type="text" name='keyword' value="<c:out value="${pageMaker.criteria.keyword}"></c:out>">
	<button class="btn btn-default">검색</button>

	<input type="hidden" name="curPage" value="${pageMaker.criteria.curPage}">
	<input type="hidden" name="pageSize" value="${pageMaker.criteria.pageSize}">
</form>
                            <button id='regBtn' type="button" class="btn btn-xs pull-right">Register New Board</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table class="table table-striped table-bordered table-hover">
                                <THEAD>
                                	<%=ClassUtil.makeTableHeader(BoardVO.class)%>
                                </THEAD>
                                <c:forEach items="${list}" var="board">
                                	${board.makeTableRow()}
                                </c:forEach>
                               	<!-- 
                               	<tr>
                               		<td><c:out value="${board.id}"></c:out></td>
                               		<td><c:out value="${board.title}"></c:out></td>
                               		<td><c:out value="${board.writer}"></c:out></td>
                               		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}"></fmt:formatDate></td>
                               		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}"></fmt:formatDate></td>
                               	</tr>
                               	 -->
                            </table>
                            
                            <!-- Pagination -->
                            <div class='pull-right'>
                            	<ul class='pagination'>
                            		<c:if test="${pageMaker.prev }">
                            			<li class="paginate_button previous">
                            				<a href="${pageMaker.startPage - 1 }">&lt;&lt;</a>
                            			</li>
                            		</c:if>
                            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
                            			<li class="paginate_button ${pageMaker.criteria.curPage == num ? "active" : ""}">
                            				<a href="${num}">${num}</a>
                            			</li>
                            		</c:forEach>
                            		<c:if test="${pageMaker.next }">
                            			<li class="paginate_button next">
                            				<a href="${pageMaker.endPage + 1 }">&gt;&gt;</a>
                            			</li>
                            		</c:if>
                            	</ul>
                            </div>
                            <!-- End Pagination -->
                            
                            <!-- Modal -->
                            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                                        </div>
                                        <div class="modal-body">
                                            처리가 완료 되었습니다.
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <!-- /.modal-content -->
                                </div>
                                <!-- /.modal-dialog -->
                            </div>
                            <!-- /.modal -->
                            
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
	var result = '<c:out value="${result}" />';
	checkModal(result);
	
	history.replaceState({}, null, null);
	function checkModal(result) {
		if (result === '' || history.state) {
			return;
		}
		$(".modal-body").html("게시글 " + result + "번이 등록되었습니다.");
		$("#myModal").modal("show");
	}
	
	$("#regBtn").on("click", function(){
		self.location = "/board/insert";
	});
	
	var activeForm = $("#activeForm");
	$(".paginate_button a").on("click", function(e) {
		e.preventDefault();
		activeForm.find("input[name='curPage']").val($(this).attr("href"));
		activeForm.submit();
	});
	
	$(".move").on("click", function(e) {
		e.preventDefault();
		activeForm.append("<input type='hidden' name='id' value='" + $(this).attr("href") + "'>");
		activeForm.attr("action", "/board/get");
		activeForm.submit();
	});
	
	$("#activeForm button").on("click", function(e) {
		if (!activeForm.find("option:selected").val()) {
			alert("검색 종류를 선택하세요!");
			return;
		}

		if (!activeForm.find("input[name='keyword']").val()) {
			alert("키워드를 입력하세요!");
			return;
		}
		activeForm.find("input[name='curPage']").val(1);
		e.preventDefault();
		activeForm.submit();
	});
})
//-->
</script>
