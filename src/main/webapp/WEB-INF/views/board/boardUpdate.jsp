<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head> 
<body>
    <div class="container">
        <div class="header">
            <h3 class="text-muted">게시판 수정</h3>
            <input id="boardNo" type="hidden" value="${b.BOARD_NO}">
            <input id="nowPage" type="hidden" value="${nowPage}">
            
        </div>
        			<!-- title 영역 -->
                    <div class="form-group">
                        <label class="col-md-12" for="txtTitle">제목</label>
                        <div class="col-md-12">
                            <input type="text" id="txtTitle" name="title" value="${b.BOARD_TITLE}" class="form-control input-md"><!--required : 공백입력시 경고-->
                        </div>
                    </div>
                    
                    <!-- 내용 영역 -->
                    <div class="form-group">
                        <label class="col-md-12" for="txtPost">내용</label>
                        <div class="col-md-12">
                            <textarea class="form-control" id="txtPost" maxlength="1000" name="content" style="height:260px;" required>${b.BOARD_CONTENTS}</textarea>
                        </div>
                    </div>
                    <br>
                    <!-- 파일 리스트 영역 -->
                    <c:if test="${!empty fList}">
	                  <div class="form-group">
	                  	<label class="col-md-12">첨부파일 목록</label>
							<c:forEach var="f" items="${fList}">
									<label class="col-md-12" id="fileList${f.file_No}"><a>${f.origin_Name} &nbsp;</a> <button id="deleteBtn${f.file_No}">X</button> </label>
							</c:forEach>
		              </div>
		             </c:if>
		              <!-- 이미지 추가 삽입 -->
		             <div class="form-group">
			             <form id="insertFiles" action="insertFile.do" method="post" enctype="multipart/form-data">
	                     <input type="hidden" id="board_No" name="board_No" value="${b.BOARD_NO}">
							<div class="form-group">
								<input type="file" id="uploadFiles" name="files" multiple="multiple" accept=".png, .jpg, .jpeg" >
		                    </div>
	                     </form>
                     </div>
                    
                    <!-- Button -->
                    <c:if test="${!empty b.USER_NO}">
                    <div class="form-group">
                        <label class="col-md-12 control-label" for="singlebutton"></label>
                        <div class="col-md-12">
                            <input id="UpdateBtn" name="singlebutton" class="btn btn-primary" readonly="readonly" value="수정하기">
                            <input class="btn btn-primary" value="취소" onclick="location.href='/'">
                        </div>
                 	</div>
                  	</c:if>
                  <c:if test="${empty b.USER_NO}">
                    <div class="form-group">
                        <label class="col-md-12 control-label" for="singlebutton"></label>
                        <div class="col-md-12">
                            <input id="nmUpdateBtn" name="singlebutton" class="btn btn-primary" value="수정하기">
                            <input class="btn btn-primary" value="취소" readonly="readonly" onclick="window.history.back();">
                        </div>
                 	</div>
                  </c:if>
                  
                  
                  
    </div>
     <script type="text/javascript" src="/js/board/boardUpdate.js"></script>
    	
</body>
</html>