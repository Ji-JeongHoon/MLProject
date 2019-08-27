<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script>

	$(document).on('click', '#btnSave', function(e){

		e.preventDefault();


		$("#form").submit();

	});

	

	$(document).on('click', '#btnList', function(e){

		e.preventDefault();

		
		location.href="./boardPage";

	});

	</script>
	
    
    
<style>

body {

  

  padding-bottom: 30px;
  
 

}



</style>