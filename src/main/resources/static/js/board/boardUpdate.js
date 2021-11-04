
// 수정하기 버튼
$("#UpdateBtn").on("click", function() {
	
	const params = new URLSearchParams();
	let bNo = $("#boardNo").val();
	let nowPage = $('#nowPage').val();
	
	params.append("BOARD_TITLE", $('#txtTitle').val());
	params.append("BOARD_CONTENTS", $('#txtPost').val());
	params.append("BOARD_NO", bNo);
	params.append("nowPage", nowPage);
	
	if($('#txtTitle').val() == ""){
		alert("제목을 입력해주세요.");
		$('#txtTitle').focus();
		return;
	}
	if($('#txtPost').val() == ""){
		alert("제목을 입력해주세요.");
		$('#txtPost').focus();
		return;
	}
	
	let fileChecks = $("#uploadFiles").val();
	
	axios.post("/updateBoard.bo", params)
		.then( res => {
			if(res.data > 0){
				if(!fileChecks){
					// 이미지 첨부를 안했을경우
					alert("수정성공!.");
					document.location.href="/"
				}else{
					// 이미지 첨부를 했을경우
					// 이미지 form submit
					alert("수정성공!!.");
					$('#insertFiles').submit();
				}
				
				
			} else{
				alert("다시 시도해주세요.");
			}
		}).catch(err =>{
			alert("서버 오류. 다시 시도해주세요.")
		})
	
})

// 비회원 게시글 수정하기 버튼
$("#nmUpdateBtn").on("click", function() {
	
	const params = new URLSearchParams();
	let bNo = $("#boardNo").val();
	let nowPage = $('#nowPage').val();
	
	params.append("BOARD_NO", bNo);
	params.append("BOARD_TITLE", $('#txtTitle').val());
	params.append("BOARD_CONTENTS", $('#txtPost').val());
	params.append("nmPassword", $('#txtPwd').val());
	params.append("nowPage", nowPage);
	
	if($('#txtTitle').val() == ""){
		alert("제목을 입력해주세요.");
		$('#txtTitle').focus();
		return;
	}
	if($('#txtPost').val() == ""){
		alert("제목을 입력해주세요.");
		$('#txtPost').focus();
		return;
	}
	if($('#txtPwd').val() == ""){
		alert("비밀번호를 입력해주세요.");
		$('#txtPwd').focus();
		return;
	}
	
	axios.post("/nmUpdateBoard.bo", params)
		.then( res => {
			if(res.data > 0){
				alert("수정성공!.");
				document.location.href="/boardDetail.bo?BOARD_NO="+bNo+'&nowPage='+nowPage
			} else{
				alert("다시 시도해주세요.");
			}
		}).catch(err =>{
			alert("서버 오류. 다시 시도해주세요.")
		})
	
})


$("[id^=deleteBtn]").on("click", function() {
	
	let id = $(this)[0].id;
	let no = id.replace(/[^0-9]/g,'');
	
	
	$.ajax({
			url: 'deleteFile.do',
			data: {file_No: no},
			success: function(data){
				console.log("반환값 확인" + data);
				if(data != '0'){
					$("#fileList"+no).hide();
				} else {
					alert("이미지 삭제 실패!");
				}
			}	
		});
});
