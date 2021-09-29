<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css/user/login.css">
</head>
<body>
	<div align="center" class="loginArea">
		<img id="logo" src="/images/logo.png">
		<hr align="center" style="background: black; width: 19.5%;">
		<br>
		<form action="login.do" method="post">
			<table id="loginTable" style="text-align:center;">
				<tr>
					
					<td colspan="2"><input type="text" name="USER_ID" placeholder="아이디"></td>
				</tr>			
				<tr>
					
					<td colspan="2"><input type="password" name="USER_PWD" placeholder="비밀번호"></td>
				</tr>
				<tr>
					<td colspan="3"><button id="loginBtn">로그인</button></td>
				</tr>
				<tr>
					<td colspan="3">
						<a href="signUpPage.do">| 회원가입 |</a>
					</td>
				</tr>
			</table>
		</form>
	<br>
	</div>
<script type="text/javascript" src="/js/user/login.js" ></script>
</body>
</html>