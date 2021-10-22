<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/board/boardDetail.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.5.2/bootbox.min.js"></script>
	
</head>
<body>
	<c:import url="../nav/nav.jsp"></c:import>
	<br><br><br><br>
	<div class="container">
		<div class="row">
		<form method="post" id="updateForm" action="updatePage.bo">
			<input type="hidden" name="BOARD_NO" id="BOARD_NO" value="${bDetail.BOARD_NO}">
			<input type="hidden" name="BOARD_TITLE" value="${bDetail.BOARD_TITLE}">
			<input type="hidden" name="BOARD_CONTENTS" value="${bDetail.BOARD_CONTENTS}">
			<input type="hidden" name="nowPage" value="${nowPage}">
		</form>
				<a onclick="location.href='/?nowPage='+${nowPage}" class="btn btn-primary">목록</a>
				<c:if test="${loginUser.USER_NO eq bDetail.USER_NO}">
					<a id="boardUpdate" class="btn btn-primary">수정</a>
					<a id="boardDelete" class="btn btn-primary">삭제</a>
				</c:if>
				<c:if test="${bDetail.USER_NO==''}">
					<a id="nmBoardUpdate" class="btn btn-primary">수정</a>
					<a id="nmBoardDelete" class="btn btn-primary">삭제</a>
				</c:if>
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align: center;">게시글</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td style="width: 20%;">글제목</td>
						<td colspan="2">${bDetail.BOARD_TITLE}</td>
					</tr>
					<tr>
						<td>작성자</td>
						<c:if test="${!empty bDetail.BOARD_WRITER}">
						<td colspan="2">${bDetail.BOARD_WRITER}</td>
						</c:if>
						<c:if test="${empty bDetail.BOARD_WRITER}">
						<td colspan="2">비회원</td>
						</c:if>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2">${bDetail.BOARD_DATE}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="2" style="text-align: left; white-space: pre; "><textarea spellcheck="false" style="border: 0px;  outline:none; min-height:300px; min-width: 100%; resize: none;"><c:out value="${bDetail.BOARD_CONTENTS}"/></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
	<!-- 수정 모달 팝업 부분 -->
		<div class="container2"> <!-- 컨테이너 영역 -->
		  <div class="popup-wrap" id="popup"> <!-- 모달창을 감쌀 박스 -->
		    <div class="popup">	<!-- 실질적 모달팝업 -->
		      <div class="popup-body">	<!-- 컨텐츠 영역 -->
		        <div class="body-content">
		          <div class="body-titlebox">
		            <h3>비밀번호를 입력해주세요.</h3>
		          </div>
		          <div class="body-contentbox">
		            <input id="modalPWd" type="password">
		          </div>
		        </div>
		      </div>
			      <div class="popup-foot"> <!-- 푸터 버튼 영역 -->
			        <span class="pop-btn confirm" id="confirm">확인</span>
			        <span class="pop-btn confirm" id="close">취소</span>
			      </div>
				</div>
			</div>
		</div>
		
		
		
		
	<!-- 삭제 모달 팝업 부분 -->
		<div class="container2"> <!-- 컨테이너 영역 -->
		  <div class="popup-wrap" id="popup2"> <!-- 모달창을 감쌀 박스 -->
		    <div class="popup">	<!-- 실질적 모달팝업 -->
		      <div class="popup-body">	<!-- 컨텐츠 영역 -->
		        <div class="body-content">
		          <div class="body-titlebox">
		            <h3>비밀번호를 입력해주세요.</h3>
		          </div>
		          <div class="body-contentbox">
		            <input id="modalPWd2" type="password">
		          </div>
		        </div>
		      </div>
			      <div class="popup-foot"> <!-- 푸터 버튼 영역 -->
			        <span class="pop-btn confirm" id="confirm2">확인</span>
			        <span class="pop-btn confirm" id="close2">취소</span>
			      </div>
				</div>
			</div>
		</div>
		
		
	<script src="js/bootstrap/bootstrap.js"></script>
	<script src="js/bootbox.js"></script>
	
		<script type="text/javascript" src="/js/board/boardDetail.js"></script>
		<script type="text/javascript" src="/js/nav/nav.js"></script>
</body>
</html>