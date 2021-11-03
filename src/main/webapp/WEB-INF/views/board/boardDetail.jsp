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
<style type="text/css">
.list-group-item{
	margin-left: 0px;
}
</style>
	
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
			<input type="hidden" id="searchType" value="${searchType}">
			<input type="hidden" id="keyword" value="${keyword}">
		</form>
				<c:if test="${keyword ne null}">
					<a onclick="location.href='searchBoard.bo?nowPage='+${nowPage}+'&searchType='+$('#searchType').val()+'&keyword='+$('#keyword').val();" class="btn btn-primary">목록</a>
				</c:if>
				<c:if test="${keyword eq null}">
					<a onclick="location.href='/?nowPage='+${nowPage}" class="btn btn-primary">목록</a>
				</c:if>
				
				<c:if test="${loginUser.USER_NO eq bDetail.USER_NO}">
					<a id="boardUpdate" class="btn btn-primary">수정</a>
					<a id="boardDelete" class="btn btn-primary">삭제</a>
				</c:if>
				<c:if test="${bDetail.USER_NO==''}">
					<a id="nmBoardUpdate" class="btn btn-primary">수정</a>
					<a id="nmBoardDelete" class="btn btn-primary">삭제</a>
				</c:if>
			<table id="table" class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
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
						<td colspan="2" id="textTd"><textarea id="textA" style="resize: none;" spellcheck="false"><c:out value="${bDetail.BOARD_CONTENTS}"/></textarea></td>
					</tr>
				</tbody>
			</table>
		</div>
		
		
		<!--  댓글 작성 -->
		<c:if test="${!empty loginUser}">
		    <div class="card mb-2">
				<div class="card-body">
					<ul class="list-group list-group-flush">
					    <li class="list-group-item">
							<textarea class="form-control" maxlength="200" placeholder="댓글을 입력하세요.(최대 200글자)" id="content" rows="3" style="resize: none;"></textarea><br>
							<button type="button" class="btn btn-dark mt-3" id="commentInsertBtn">댓글 작성</button>
					    </li>
					</ul>
				</div>
			</div>
		</c:if>
		<hr>
		<div class="card mb-2">
			<div class="card mb-2">
			<c:forEach var="c" items="${cList}">
					<div class="card-body">
						<ul class="list-group list-group-flush">
						    <li class="list-group-item" id="replyContent" style="
						    <c:if test="${empty c.comment_Depth || c.comment_Depth ne 0}">
						    margin-left: ${c.comment_Depth}00px;
						    </c:if>
						    ">
							    <b>${c.comment_Writer}</b>
							    <c:if test="${c.comment_Writer eq bDetail.BOARD_WRITER}">
							    	<span style="font-size:15px; background: orange; color:white; border-radius: 4px; border-color: orange; ">작성자</span>
							    </c:if>
								    <c:if test="${!empty loginUser && c.delete_Yn == 'N'}">
							   	 		<textarea id="rcontent${c.comment_No}" readonly="readonly" rows="3" class="form-control" style="resize: none; cursor:auto; background: white;">${c.comment_Content}</textarea>
								    	<span style="font-size: 10px; color: gray;">작성일 : ${c.create_Date} </span> &nbsp; &nbsp;
								    	<c:if test="${c.comment_Depth < 3}">
								    		<span id="rreply${c.comment_No}" style='cursor:pointer; font-size: 10px;'> 답글쓰기 </span> &nbsp;
								    	</c:if>
								    	<c:if test="${c.comment_Writer eq loginUser.USER_NICKNAME}">
								    	<span id="rreplyUpdate${c.comment_No}" style='cursor:pointer; font-size: 10px;'>수정하기</span>&nbsp;
								    	<span id="rreplyDelete${c.comment_No}" style='cursor:pointer; font-size: 10px;'>삭제하기</span>
								    	</c:if>
								    	<br>
								    	<button type="button" class="btn btn-dark mt-3" id="commentUpdateBtn${c.comment_No}" style="display: none;">댓글 수정</button>
								    </c:if>
								     <c:if test="${empty loginUser && c.delete_Yn == 'N'}">
								    	<b><textarea readonly="readonly" rows="3" class="form-control" style="resize: none; cursor:auto; background: white;">회원만 확인 가능합니다.</textarea></b>
								    </c:if>
								    <c:if test="${c.delete_Yn == 'Y'}">
								    	<b><textarea readonly="readonly" rows="3" class="form-control" style="resize: none; cursor:auto; color:red; background: white;">삭제된 댓글 입니다.</textarea></b>
								    </c:if>
								    
								    
							    <form>
									<input type="hidden" id="cNo${c.comment_No}" value="${c.comment_No}">
									<input type="hidden" id="comment_Parent${c.comment_No}" value="${c.comment_Parent}">
									<input type="hidden" id="comment_Depth${c.comment_No}" value="${c.comment_Depth}">
									<input type="hidden" id="comment_Order${c.comment_No}" value="${c.comment_Order}">
									<input type="hidden" id="comment_Group${c.comment_No}" value="${c.comment_Group}">
									<li class="list-group-item" id="rrreply${c.comment_No}" style="display: none;">
										<textarea class="form-control" maxlength="200" placeholder="댓글을 입력하세요.(최대 200글자)" id="rrcontent${c.comment_No}" rows="3" style="resize: none;"></textarea><br>
										<button type="button" class="btn btn-dark mt-3" id="rcommentInsertBtn${c.comment_No}">답글 작성</button>
									</li>
								</form>
						    </li>
						</ul>
					</div>
			</c:forEach>	
			</div>
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
			        <span class="pop-btn confirm" id="close">취소</span><br>
			        <input type="text">
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