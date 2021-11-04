<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="/css/board/boardList.css">
<link rel="stylesheet" href="/css/user/mypage.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <c:import url="../common/header.jsp"></c:import>
   <c:import url="../nav/nav.jsp"></c:import>
   
	<div class="container">
			<table id="table" class="table table-striped" style="text-align: center; margin-top:30px; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="2" style="background-color: #eeeeee; text-align: center;">정보</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">회원 ID</td>
						<td style="width: 20%;">${u.USER_ID}</td>
					</tr>
					<tr>
						<td style="width: 20%;">닉네임</td>
						<td style="width: 20%;">${u.USER_NICKNAME}</td>
					</tr>
					<tr>
						<td style="width: 20%;">휴대전화</td>
						<td style="width: 20%;">${u.USER_PHONE}</td>
					</tr>
					<tr>
						<td style="width: 20%;">비밀번호</td>
						<td style="width: 20%;"><input id="pwd" type="password"></td>
					</tr>
					<tr>
						<td colspan="2">
							<span class="sp">비밀번호 수정 </span><input type="radio" name="modify" value="0" class="chk" checked="checked">
							<span class="sp">개인정보 수정 </span><input type="radio" name="modify" value="1" class="chk">
							<span class="sp">회원 탈퇴 </span><input type="radio" name="modify" value="2" class="chk">
							<input type="submit" id="btn" value="확인">
						</td>
					</tr>
				</tbody>
			</table>
			<form method="post" id="deleteUser" action="deleteUser.do">
				<input type="hidden" id="uNo" name="USER_NO" value="${u.USER_NO}">
			</form>
			
			
		
		
	</div>
	<c:import url="../common/footer.jsp"></c:import>
	 <script type="text/javascript" src="/js/nav/nav.js" ></script>
	 <script type="text/javascript" src="/js/user/mypage.js"></script>
</body>
</html>