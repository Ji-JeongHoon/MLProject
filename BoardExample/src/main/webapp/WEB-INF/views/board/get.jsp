<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<%@ page import="org.zerok.board.domain.BoardVO" %>
<%@ page import="org.ivar.framework.ClassUtil" %>
<%@ page import="org.ivar.framework.DisplayControl" %>

<script type="text/javascript" src="/resources/js/reply.js"></script>

<%@include file="../includes/header.jsp" %>

<form id='operForm' action="/board/update" method="get">
	<input type="hidden" id='id' name="id" value="${board.id}">
	<input type="hidden" name="curPage" value="${criteria.curPage}">
	<input type="hidden" name="pageSize" value="${criteria.pageSize}">
	<input type="hidden" name='keyword' value="<c:out value="${criteria.keyword}"></c:out>">
	<input type="hidden" name='type' value="<c:out value="${criteria.type}"></c:out>">
</form>

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">게시글 조회</div>
				<!-- /.panel-heading -->
				<div class="panel-body">
						<div class="form-group">
							<label>번호</label>
							<input class="form-control" name="id" value="<c:out value="${board.id}" />" readonly="readonly">
						</div>
						<div class="form-group">
							<label>제목</label>
							<input class="form-control" name="title" value="<c:out value="${board.title}" />" readonly="readonly">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows=3 name="contents" readonly="readonly" >
								<c:out value="${board.contents}" />
							</textarea>
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input class="form-control" name="writer" value="<c:out value="${board.writer}" />" readonly="readonly">
						</div>
						<button data-oper="update" class="btn btn-default">수정</button>
						<button data-oper="list" class="btn btn-info">목록 보기</button>
				</div>
				<!-- /.panel-body -->
			</div>
			<!-- /.panel -->

			<!-- 댓글 영역 -->			
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i> Reply
					<button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>new reply</button>
				</div>
				<div class="panel-body">
					<ul class="chat">
					</ul>
				</div>
				
				<!-- 댓글 페이지 점프  -->			
				<div class="panel-footer">
				</div>
				
			</div>
		</div>
		<!-- /.col-lg-6 -->
	</div>
	<!-- /.row -->
<%@include file="../includes/footer.jsp" %>
<!-- 댓글 입력 모달 창 -->
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">Reply Modal</h4>
            </div>
            <div class="modal-body">
            	<div class='form-group'>
            		<label>댓글</label>
            		<input class='form-control' name='contents' value='New Reply!!!'>
            	</div>
            	<div class='form-group'>
            		<label>작성자</label>
            		<input class='form-control' name='writer'>
            	</div>
            </div>
            <div class="modal-footer">
                <button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
                <button id='modalUpdateBtn' type="button" class="btn btn-warning">Update</button>
                <button id='modalDeleteBtn' type="button" class="btn btn-danger">Delete</button>
                <button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<script type="text/javascript">
<!--
$(document).ready(function(){
	var operForm = $("#operForm");
	console.log(replyService);
	
	$("button[data-oper='update']").on("click", function(e) {
		operForm.attr("action", "/board/update").submit();
	});

	$("button[data-oper='list']").on("click", function(e) {
		operForm.find("#id").remove();		
		operForm.attr("action", "/board/list");
		operForm.submit();
	});
	
	var originalID = '<c:out value="${board.id}" />';
	var replyUL = $(".chat");
	
	var PAGE_SIZE = 3;
	var PAGE_NAV_SIZE = 2;
	
	showList(1);
	
	function showList(pageNo) {
		replyService.getList({pid:originalID, page:pageNo, pageSize:PAGE_SIZE},
				function(total, list) {
					alert("getList 정상 작동 중 " + list.length + " 개 조회 됨");
					if (pageNo == -1) {
						/* 마지막 페이지 조회하기 */
						pageNum = Math.ceil(total / parseFloat(PAGE_SIZE));
						showList(pageNum);
						return;
					}
					
					var strOut = "";
					
					for (var i = 0, len = list.length; i < len; i++) {
						strOut += "<li class='left clearfix' data-id='" + list[i].id + "'>";
						strOut += "  <div> ";
						strOut += "    <div class='header'>";
						strOut += "        <strong class='primary-font'>" + list[i].writer + "</strong>";
						strOut += "        <small class='pull-right text-muted'>" + list[i].regDate + "</small>";
						strOut += "     </div>";
						strOut += "     <p>" + list[i].contents + "</p>";
						strOut += "  </div>";
						strOut += "</li>";
					}
					replyUL.html(strOut);
					showReplyPage(total);
				},
				function(er) {
					alert("Error : " + er);
				}
		);
	}

	var pageNum = 1;
	var replyPageFooter = $(".panel-footer");
	function showReplyPage(replyCnt) {
		var endNum = Math.ceil(pageNum / parseFloat(PAGE_NAV_SIZE)) * PAGE_NAV_SIZE;
		console.log("end page nav = " + endNum);
		
		var startNum = endNum - PAGE_NAV_SIZE + 1;
		
		var prev = startNum != 1;
		var next = false;

		if (endNum * PAGE_SIZE >= replyCnt) {
			endNum = Math.ceil(replyCnt/parseFloat(PAGE_SIZE));
		}
		
		if (endNum * PAGE_SIZE < replyCnt) {
			next = true;
		}
		
		var outStr = "<ul class='pagination pull-right'>";
		if (prev) {
			outStr += "<li class='page-item'>";
			outStr += "<a class='page-link' href='" + (startNum - 1) + "'>&lt;&lt;</a>";
			outStr += "</li>";
		}

		for (var i = startNum; i <= endNum; i++) {
			var active = pageNum == i ? "active" : "";

			outStr += "<li class='page-item " + active + "'>";
			outStr += "<a class='page-link' href='" + i + "'>" + i + "</a>";
			outStr += "</li>";
		}
		
		if (next) {
			outStr += "<li class='page-item'>";
			outStr += "<a class='page-link' href='" + (endNum + 1) + "'>&gt;&gt;</a>";
			outStr += "</li>";
		}
		
		outStr += "</ul>";
		
		replyPageFooter.html(outStr);
	}
	
	replyPageFooter.on("click", "li a", function(e) {
		e.preventDefault();
		var targetPageNum = $(this).attr("href");
		pageNum = targetPageNum;
		showList(pageNum);		
	});
	
	/* 댓글 추가 시 모달 창을 통해 처리 */
	var modal = $(".modal");
	var modalInputContents = modal.find("input[name='contents']");
	var modalInputWriter = modal.find("input[name='writer']");

	var modalRegisterBtn = $("#modalRegisterBtn");
	var modalUpdateBtn = $("#modalUpdateBtn");
	var modalDeleteBtn = $("#modalDeleteBtn");

	$("#addReplyBtn").on("click", function(e) {
		modal.find("input").val("");
		modal.find("button[id != 'modalCloseBtn']").hide();
		modalRegisterBtn.show();
		
		$(".modal").modal("show");
	});
	
	modalRegisterBtn.on("click", function(e) {
		var reply = {
			pid:originalID,
			contents:modalInputContents.val(),
			writer:modalInputWriter.val()
		};
		
		replyService.add(
				reply,
				function(result) {
					modal.find("input").val("");
					modal.modal("hide");
					showList(-1);
				},
				function(er) {
					alert("Error : " + er);
				}
			);
	});
	
	$(".chat").on("click", "li", function(e) {
		var id = $(this).data("id");

		replyService.get(id,
				function(reply) {
					modalInputContents.val(reply.contents);
					modalInputWriter.val(reply.writer);
					modal.data("id", reply.id);
					
					modal.find("button[id != 'modalCloseBtn']").hide();
					modalUpdateBtn.show();
					modalDeleteBtn.show();
					
					modal.modal("show");
				},
				function(er) {
					alert("Error : " + er);
				}
		);

	});
	
	modalUpdateBtn.on("click", function(e) {
		var reply = {id:modal.data("id"), contents:modalInputContents.val()};

		console.log("modalUpdateBtn Clicked");
		console.log(reply);
		
		replyService.update(
				reply,
				function(result) {
					modal.modal("hide");
					showList(pageNum);
				},
				function(er) {
					alert("Error : " + er);
				}
		);
	});

	modalDeleteBtn.on("click", function(e) {
		var id = modal.data("id");
		
		replyService.remove(id,
				function(count) {
					modal.modal("hide");
					showList(pageNum);
				},
				function(er) {
					alert("Error : " + er);
				}
		);
	});

})
//-->
</script>            