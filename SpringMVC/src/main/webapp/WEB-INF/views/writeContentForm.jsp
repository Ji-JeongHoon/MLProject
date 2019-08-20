<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function calc(){
		var x = document.getElementById("x").value;
		
		var y = document.getElementById("y").value;
		
		var sum;
		
		sum = parseInt(x) + parseInt(y);
		document.getElementById("sum").value = sum;
		
	}



</script>

</head>
<body>
	<div id="wrapper">
		<h1>글 쓰기</h1><br>
		<form action="./writeContentAction" method="post" enctype="multipart/form-data">
			작성자 : ${sessionData.m_nick }<br>
			제목 : <input type="text" name="c_title"><br>
			내용 : <br>
			<textarea rows="20" cols="45" name="c_content">
			</textarea>		
			<br>
			<input type="file" name="files" multiple><br>
			<input type="submit" value="저장">
		</form>
	</div>
	
	
	<h3> 덧셈 계산기</h3>
	
	<form name="myform" action="..." method=Post>
	첫번째 정수 : 
	<input id = "x"/><br>
	두번째정수 : <input id = "y"/><br>
	합계:
	<input id="sum"/><br>
	<input type = "button" value="계산"  onclick="calc();"/>
	
	</form>
	
	
	<script>


    document.write("<h1>구구단표</h1>");
    document.write("<table border=2 width=50%");

    for (var i = 1; i <= 9; i++) {  
        document.write("<tr>");
        

        for (var j = 1; j <= 9; j++) { 
            document.write("<td>" + i * j + "</td>");
        }

        document.write("</tr>");
    }

    document.write("</table>");

</script>
	

</body>
</html>















