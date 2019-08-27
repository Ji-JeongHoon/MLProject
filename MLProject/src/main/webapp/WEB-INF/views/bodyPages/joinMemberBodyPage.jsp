<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <div id="alert" class="alert alert-warning alert-dismissible fade show" role="alert" style="display:none">
    	아이디를 확인해주세요.
	  <button type="button" class="close" onclick="alertclose()">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
    
	<div class="join">
		<form class="form-join needs-validation" novalidate action="./joinMemberAction" method="post">
			<h1 class="text-center">Sign Up</h1>
			<div class="form-group mb-1">
				<label for="inputId">Email</label>
				<input type="email" id="inputId" class="form-control" name="m_id" placeholder="name@email.com" required autofocus>
			</div>
			<button type="button" class="btn btn-outline-primary mb-3" onclick="confirmId()">아이디 중복 확인</button>
			<div id="confirmText"></div>
			<div class="form-group">
				<label for="inputPassword">Password</label>
				<input type="password" class="form-control" name="m_password" placeholder="Password" required>
			</div>
			
			<div class="form-group mb-1">
				<label for="inputNickname">Nickname</label>
				<input type="text" id="inputNickname" class="form-control" name="m_nickname" placeholder="Nickname" required>
			</div>
			<button class="btn btn-outline-primary mb-3">닉네임 중복 확인</button>
			<button type="submit" class="btn btn-primary" id="submit">회원가입</button>
		</form>
	</div>
	
	<script type="text/javascript">
		var checkIdValidity = false;
		var checkNicknameValidity = false;
		
		function confirmId() {
			// 입력된 id
			var inputId = $("#inputId").val();
			
			// ui
			var confirmText = document.getElementById('confirmText');
			console.log(confirmText);
			
			$.ajax({
				async: true,
				type : 'POST',
				data : inputId,
				url : "confirmIdAction",
				dataType : "json",
				contentType : "application/json; charset-UTF-8",
				success : function(data) {
					if(data.isValid == false) {
						confirmText.innerText = "이미 등록된 이메일입니다.";
						confirmText.style.color = "red";
					} else {
						confirmText.innerText = "사용 가능한 이메일입니다.";
						confirmText.style.color = "blue";
						checkIdValidity = true;
					}
				},
				error : function(error) {
					alert("error : " + error);
				}
			});
		};
		
		(function() {
		  'use strict';
		  window.addEventListener('load', function() {
		    // Fetch all the forms we want to apply custom Bootstrap validation styles to
		    var forms = document.getElementsByClassName('needs-validation');
		    // Loop over them and prevent submission
		    var validation = Array.prototype.filter.call(forms, function(form) {
		      form.addEventListener('submit', function(event) {
		        if (form.checkValidity() === false) {
					event.preventDefault();
					event.stopPropagation();
		        } else if(checkIdValidity == false) {
		        	event.preventDefault();
					event.stopPropagation();
					$('.alert').alert();
					$('#alert').show();
		        }
		        form.classList.add('was-validated');
		      }, false);
		    });
		  }, false);
		})();
		
		function alertclose() {
			$('#alert').hide();
		}
	</script>
