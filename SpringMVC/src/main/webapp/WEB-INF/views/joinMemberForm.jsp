<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<script>
	function confirmID(){
		
		console.log("컨펌아이디 호출됨!!");
		
		
		//ID 입력 양식에 입력 된 값 가져오기...
		var id = document.getElementById("inputID").value;
		
		
		//AJAX 호출.. 
		var xmlhttp = new XMLHttpRequest();
		
		//호출 후 값을 받았을때 처리 로직..
		xmlhttp.onreadystatechange = function(){
			//총 5번을 돌게 되는데 4번이 값을 받는 시점... 
			if(xmlhttp.readyState==4 && xmlhttp.status == 200){
				
				//alert(xmlhttp.responseText);
				
				
				//JSON 타입으로 만들어주는 api
				var result = JSON.parse(xmlhttp.responseText);
				
				//로직 처리 및 UI 처리...
				
				var result_box = document.getElementById("result_box");
				
				
				if (result.exist == true){
					
				result_box.style.color = "red";
				result_box.innerText = "이미 존재하는 아이디 입니다."	
					
				//	alert("이미 존재 하는 아이디 입니다.");
				}else{
				
				result_box.style.color = "green";
				result_box.innerText = "사용 가능한 아이디 입니다."	
					
					//alert("사용가능한 아이디 입니다.");
				}				
				
				
			}
			
		};
		
		
		xmlhttp.open("post","./isExistID", true);
		xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xmlhttp.send("m_id=" + id);
		
	}
	


</script>

</head>
<body>
	<div id="wrapper">
		회원 가입 <br>
		<form action="./joinMemberAction" method="post">
			ID : <input id = "inputID" type="text" name="m_id" onblur="confirmID()"><br>
			<div id ="result_box"></div>
			
			PW : <input type="text" name="m_pw"><br>
			NICK : <input type="text" name="m_nick"><br>
			Phone : <input type="text" name="m_phone"><br>
			Address : <input type="text" name="m_address"><br>
			<input type="submit" value="회원 가입">			
		</form>
	</div>
</body>
</html>


















