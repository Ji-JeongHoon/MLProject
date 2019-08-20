<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	파일 업로드 TEST <br>
	
	<form action="./fileUploadAction" method="post" enctype="multipart/form-data">
		입력 텍스트 : <input type="text" name ="value1"><br>
		<!-- 뒤에 multiple 누르면 파일 여러개 가능^^ -->
		파일 선택 : <input type="file" name = "files" multiple><br>
		<input type="submit" value="전송">
	
	</form>




</body>
</html>