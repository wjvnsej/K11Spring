<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<script>
$(function(){
	
});
</script>

</head>
<body>
<div class="container">

	<h2>DI(의존주입)을 활용한 간단한 사칙연산 계산기</h2>
	
	<h3>200과 100의 사칙연산 결과는?</h3>
	
	<ul>
		<li>덧셈결과 : ${addResult }</li>
		<li>뺄셈결과 : ${subResult }</li>
		<li>곱셈결과 : ${mulResult }</li>
		<li>나눗셈결과 : ${divResult }</li>
	</ul>

</div>
</body>
</html>