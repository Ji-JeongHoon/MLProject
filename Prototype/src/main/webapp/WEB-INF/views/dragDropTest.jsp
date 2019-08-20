<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   #wrapper {
      width : 1600px;
      height : 1000px;
      margin : 30px auto;
      background-color : blue;
   }
   #input {
      width : 800px; 
      height : 1000px;
      float : left;
      background-color: beige;
   }
   #output {
      width : 800px;
      height : 1000px;
      float : left;
      background-color: salmon;
   }
   #file_upload {
      width : 800px;
      height : 100px;
      background-color: red;
   }
   #model_select {
      width : 800px;
      height : 100px;
      background-color: yellow;
   }
   #parameter {
      width : 800px;
      height : 800px;
      background-color: green;
   }
    #parameter_select {
        width : 300px;
        padding : 50px;
        height: 700px;
        float: left;
        background-color: indianred;
    }
    #parameter_put {
        width : 300px;
        padding : 50px;
        height: 700px;
        float: left;
        background-color:skyblue;
    }
    #parameter_select div {
        width : 300px;
        height: 100px;
        background-color: aliceblue;
    }
    #parameter_select input[type=text] {
        width : 50px;
    }
    #parameter_put div {
        width : 300px;
        height: 100px;
        background-color: aliceblue;
    }
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function allowDrop(ev) {
        ev.preventDefault();
    }

    function drag(ev) {
        ev.dataTransfer.setData("text/html", ev.target.id);
    }

    function drop(ev) {
        ev.preventDefault();
        var data = ev.dataTransfer.getData("text/html");
        var nodeCopy = document.getElementById(data).cloneNode(true);
        nodeCopy.id = document.getElementById(data).getAttribute("id") + "_new";
        ev.target.appendChild(nodeCopy);
        
        
        
        console.log(nodeCopy.id);
    }

    function make_string() {
        var page = document.getElementById(parameter_put);
        console.log($("#parameter_put").children().eq(0).getAttribute("id"));
        console.log($("#parameter_put").children().eq(1).getAttribute("id"));
        console.log($("#parameter_put").children().eq(2).getAttribute("id"));
    }

</script>
</head>

<body>
   <div id="wrapper">
      <div id="input">
         <div id="file_upload">
            <form action="fileUploadAction" method="post" enctype="multipart/form-data">
               <input type="file" name="file">
               <input type="submit" value="업로드">
            </form>
         </div>
         <div id="model_select">
                선택한 모델 : MLP<br>
         </div>
         <div id="parameter">
                <div id="parameter_select">
                    <div id="InputLayer_NumpyArray" draggable="true" ondragstart="drag(event)">
                        InputLayer<br>
                        <form>
                            y_label 시작 : <input type="text" name="y_label_index_starting"><br>
                            y_label 끝 : <input type="text" name="y_label_index_last">
                        </form>
                    </div>
                    <br>
                    <div id="Perceptron" draggable="true" ondragstart="drag(event)">
                        Perceptron<br>
                        <form>
                            개수 : <input type="text"><br>
                            is last? <input type="checkbox" name="final_layer">
                        </form>
                    </div>
                    <br>
                    <div id="Activation_Sigmoid" draggable="true" ondragstart="drag(event)">
                        Activation Function
                    </div>
                    <br>
                    <div id="MeanSquaredError" draggable="true" ondragstart="drag(event)">
                        MeanSquaredError
                    </div>
                    <br>
                    <div id="StochasticGradientDescent" draggable="true" ondragstart="drag(event)">
                        StochasticGradientDescent 
                    </div>
                </div>
                <div id="parameter_put" ondrop="drop(event)" ondragover="allowDrop(event)" ondragstart="drag(event)">
                    <button type="button" onclick="make_string()">제출</button>
                </div>
            </div>
      </div>
      <div id="output">
      
      </div>
    </div>
</body>
</html>