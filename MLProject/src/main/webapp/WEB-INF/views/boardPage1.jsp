
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
    <head>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        
        <style>
        
        #box1{
        	
        
        }
            
        </style>
    </head>
    <body>
        <div id="wrapper">
        
        
            <!-- navigation bar -->
            <nav class="navbar navbar-expand-lg navbar-light" style="background-color:lightsalmon;" >
                <a class="navbar-brand h1" href="#">EasyML</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav mr-auto h6">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Trial</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Educate</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Program</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Board</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="#">Sign in</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Sign up</a>
                        </li>
                    </ul>
                </div>
            </nav>
            
            
            <div id = "box1">
            <table border="1">
			<tr><td>글 번호</td><td>제목</td><td>작성자</td><td>조회수</td><td>작성일</td></tr>
			<c:forEach var="boardData" items="${boardDataList }">
				<tr>
					<td>${boardData.boardVO.b_idx }</td>
					<td><a href ="./readContentPage?b_idx=${boardData.boardVO.b_idx }">${boardData.boardVO.b_title }</a></td>
					<td>${boardData.memberVO.m_nickname }</td>
					<td>${boardData.boardVO.b_count }</td>
					<td>${boardData.boardVO.b_writedate }</td>			
				</tr>
			</c:forEach>
			</table>
            </div>

            
            
            
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>