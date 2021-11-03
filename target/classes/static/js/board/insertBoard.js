$('.guide').hide();

// 작성하기 버튼
$("#singlebutton").on("click", function() {
	
	const params = new FormData();
	// 제목
	params.append("BOARD_TITLE", $('#txtTitle').val());
	// 내용
	params.append("BOARD_CONTENTS", $('#txtPost').val());
	

	
	if($('#txtTitle').val() == ""){
		alert("제목을 입력해주세요.");
		$('#txtTitle').focus();
		return;
	}
	if($('#txtPost').val() == ""){
		alert("내용을 입력해주세요.");
		$('#txtPost').focus();
		return;
	}
	
	let fileCheck = $("#uploadFiles").val();
	
	axios.post("/insertBoard.bo", params)
		.then( function(res) {
			// 게시글 작성에 성공 했을경우
			if(res.data > 0){
				if(!fileCheck){
					// 이미지 첨부를 안했을경우
					alert("글 작성에 성공하셨습니다.");
					document.location.href="/";
				}else{
					// 이미지 첨부를 했을경우
					// form안의 board_no 에 리턴값 넣어주기
					$("#board_No").val(res.data);
					// 이미지 form submit
					$('#insertFiles').submit();
				}
			} else{
				alert("다시 시도해주세요.");
			}
		}).catch(err =>{
			alert("서버 오류. 다시 시도해주세요.");
		})
	
})
// 비회원 작성하기 버튼
$("#nmInsertBtn").on("click", function() {
	

	
	const params = new FormData();
	
	params.append("BOARD_TITLE", $('#txtTitle').val());
	params.append("BOARD_CONTENTS", $('#txtPost').val());
	params.append("nmPassword", $('#txtPwd').val());
	
	if($('#txtTitle').val() == ""){
		alert("제목을 입력해주세요.");
		$('#txtTitle').focus();
		return;
	}
	if($('#txtPost').val() == ""){
		alert("내용을 입력해주세요.");
		$('#txtPost').focus();
		return;
	}
	if($('#txtPwd').val() == ""){
		alert("비밀번호를 입력해주세요.");
		$('#txtPwd').focus();
		return;
	}
	
	axios.post("/nmInsertBoard.bo", params)
		.then(res => {
			if(res.data > 0){
				alert("글 작성에 성공하셨습니다.");
				document.location.href="/";
			} else{
				alert("다시 시도해주세요.");
			}
		}).catch(err =>{
			alert("서버 오류. 다시 시도해주세요.")
		})
    
})
$('#btn-upload').click(function (e) {
        e.preventDefault();
        $('#uploadFiles').click();
    });

