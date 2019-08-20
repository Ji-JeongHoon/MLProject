<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#wrapper{
				margin : 30px auto;
				width : 1600px;
				height : 1000px;
				background-color : blue;
				
	}
	
	#input{
				width : 800px;
				height : 1000px;
				float : left;
				background-color: beige;
	
	}
	
	#output{
	
				width : 800px;
				height : 1000px;
				float : left;
				background-color: salmon;
	
	}
	
	#file_upload{
		
			width : 800px;
			height : 100px;
			background-color : red;
	
	}
	
	#model_select{
	
			width : 800px;
			height : 100px;
			background-color : blue;
	}
	
	#parameter{
			width : 800px;
			height : 800px;
			background-color : green;
	}


</style>


<script>
	function loop(){
		
		var loopNumber = document.getElementById('layer').value;
		var layer_code = '';
		for(i = 1 ; i <= loopNumber; i++){
			
			layer_code += 'perceptron : <input type="text" name="pValue'
			layer_code += i
			layer_code += '"><br>' 
			layer_code += 'activation function : sigmoid<br>'
			
		}
		
		document.getElementById('layer_area').innerHTML =layer_code;
		
	}
	
</script>



</head>
<body>

	<div id="wrapper">
		<div id ="input">
			<div id = "file_upload">
				파일업로드!! <form action = "./fileUploadAction" method = "post" enctype="multipart/form-data">
					<input type="file" name="file" ><br>
					<input type="submit" value="업로드">
				</form>
			
			</div>
			
			<div id = "model_select">
			모델
			</div>
		
			<div id = "parameter">
				layer 개수 : <input id = "layer" type="text" name = "layerNumber">
				<button type = "button" onclick="loop()">입력</button>
				<form action = "./parameterSettingAction" method="post">
					inputLayer start index : <input type="text" name = "startIndex"><br>
					inputLayer last index : <input type= "text" name = "lastIndex">
					layer 개수 : <input type="text" name = "layerNumber">
					<div id ="layer_area"></div>
					
				
				
				
				</form>
			
			
			</div>		
		
		
		
		
		
		</div>
		
		<div id="output">
		
		
		</div>
	
	
	
	
	
	</div>



</body>
</html>