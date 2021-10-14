<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/nav/nav.css" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<div class="tab">
		<span class="image">
			<img id="logo" src="images/logo.png" style='cursor:pointer'>
		</span>
		<nav>
		<c:if test="${ empty loginUser}">
			<ul class="link">
				<li><a id="login" style='cursor:pointer'>로그인</a></li>
				<li><a id="signUp" style='cursor:pointer'>회원가입</a></li>
			</ul>
		</c:if>
		<c:if test="${!empty loginUser}">
			<ul class="link">
				<li><a style='cursor:pointer'><c:out value="${loginUser.USER_NICKNAME}님"/></a></li> 
				<li><a id="logout" href="/doLogout" style='cursor:pointer'>로그아웃</a></li>
				<li><a href="mypageForm.do" style='cursor:pointer'>내 정보보기</a></li>	
			</ul>
		</c:if>
		</nav>	
	</div>
</body>
</html>