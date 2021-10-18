<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/board/boardInsert.css"type="text/css">
    <title>write page</title> 
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head> 
<body>
    <div class="container">
        <div class="header">
            <h3 class="text-muted">게시판 글작성</h3>
        </div>
        <section>
                    <!-- Form Name -->
                    <!-- Text input-->
                    <div class="form-group">
                        <label class="col-md-12" for="txtTitle">제목</label>
                        <div class="col-md-12">
                            <input id="txtTitle" name="title" type="text" placeholder="제목을 입력하세요.(최대 30글자)" style="width: 500px;" maxlength="30"  class="form-control input-md", autofocus required><!--required : 공백입력시 경고-->
                        </div>
                    </div>
                    <c:if test="${empty loginUser}">
                    <div class="form-group">
                        <label class="col-md-12" for="txtTitle">비밀번호</label>
                        <div class="col-md-12">
                            <input id="txtPwd" name="password" type="password" placeholder="비밀번호를 입력하세요.(최대 12글자)" style="width: 300px;" maxlength="12" style="width: 200px;" class="form-control input-md", autofocus required><!--required : 공백입력시 경고-->
                        </div>
                    </div>
                    </c:if>
                    <!-- Textarea -->
                    <div class="form-group">
                        <label class="col-md-12" for="txtPost">내용</label>
                        <div class="col-md-12">
                            <textarea class="form-control" id="txtPost" name="content" placeholder="내용을 입력하세요." style="height:260px;" required></textarea>
                        </div>
                    </div>
                    <!-- Button -->
                    <div class="form-group">
                        <label class="col-md-12 control-label" for="singlebutton"></label>
                        <div class="col-md-12">
                        <c:if test="${ !empty loginUser}">
                            <input id="singlebutton" name="singlebutton" class="btn btn-primary" readonly="readonly" value="작성하기">
                         </c:if>
                         <c:if test="${ empty loginUser}">
                            <input id="nmInsertBtn" name="nmInsertBtn" class="btn btn-primary" readonly="readonly" value="작성하기">
                         </c:if>
                            <input class="btn btn-primary" onclick="window.history.back()" readonly="readonly" value="취소하기">
                        </div>
                    </div>
        </section>
    </div>
    <script type="text/javascript" src="/js/board/insertBoard.js"></script>
</body>
</html>