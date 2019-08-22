<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
		// ID 존재여부 확인...(진짜 유효성 검사는 서버쪽에서 또 해줘야 함!!!!!)
		function confirmID() {
			console.log("confirmID 호출됨...");
			
			// ID 입력양식에 입력된 값 가져오기
			var id = document.getElementById("inputID").value;
			
			// AJAX 호출
			var xmlhttp = new XMLHttpRequest();	// javascript용 라이브러리 클래스
			
			// 호출 후 값을 받았을 때 처리 로직... 뭔가 상태 변화가 일어날 때마다 호출됨.
			xmlhttp.onreadystatechange = function () {
				// readyState 4(0~4까지 반복함) : request 요쳥 후 값을 받는 시점.
				// status 200번 : 유일하게 성공한 경우.(404, 500같은 에러 안뜨고)
				if(xmlhttp.readyState==4 && xmlhttp.status==200) {
					//alert(xmlhttp.responseText);	
					var result = JSON.parse(xmlhttp.responseText); // responseText: 서버에서 받은 값 담겨있음(JSON 형태)
					
					// 로직처리 및 UI 처리...
					var result_box = document.getElementById("result_box");
					if(result.exist == true) {
						//alert("이미 존재하는 아이디입니다.");
						result_box.style.color = "red";
						result_box.innerText = "이미 존재하는 아이디입니다.";
					} else {
						//alert("사용 가능한 아이디입니다.");
						result_box.style.color = "blue";
						result_box.innerText = "사용 가능한 아이디입니다.";
					}
				}
			};
			
			// post방식으로 리퀘스트 보내서 메소드 호출(url mapping)
			xmlhttp.open("post", "./isExistID", true);	// true: 비동기식으로 통신함
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			// 입력된 id 값 서버에 보내기
			xmlhttp.send("m_id=" + id);
		}
	</script>
	
	<div id="wrapper">
	<div class="container">
		<div class="row">
			<div class="col"></div>
			<div class="col-md-auto mt-5">
				<h1>Sign Up</h1>
			</div>
			<div class="col"></div>
		</div>
		<div class="row">
			<div class="col"></div>
			<div class="col-10">
				<form class="form-join" action="./joinMemberAction" method="post">
					<div class="form-group">
						<label for="inputEmail">Email</label>
						<div class="row">
							<div class="col-8">
							<input type="email" class="form-control" name="m_id" placeholder="name@email.com" required autofocus>
							</div>
							<div class="col">
							<button type="submit" class="btn btn-primary">아이디 확인</button>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword">Password</label>
						<input type="password" class="form-control" name="m_password" placeholder="Password" required>
					</div>
					
					<div class="form-group">
						<label for="inputNickname">Nickname</label>
						<input type="text" class="form-control" name="m_nickname" placeholder="Nickname" required>
					</div>
					<button type="submit" class="btn btn-primary" id="submit">회원가입</button>
				</form>
			</div>
			<div class="col"></div>
		</div>
	</div>
	</div>