
// 수정 버튼 클릭시 수정 페이지로
$("#boardUpdate").on("click", function(){
	
	let bNo = $("#BOARD_NO").val();
	let nowPage = $("#nowPage").val();
	
	/*location.href="/updatePage.bo?bNo="+bNo+'&nowPage='+nowPage*/
	$('#updateForm').submit();
});

// 삭제 버튼
$("#boardDelete").on("click", function() {
	
	if(confirm("정말로 삭제하시겠습니까?")){
		
		let bNo = $("#boardNo").val();
		const params = new URLSearchParams();
		
		params.append("BOARD_NO", bNo);
		
		
		
		axios.post("/deleteBoard.bo", params)
			.then( res => {
				if(res.data > 0){
					alert("삭제 성공!.");
					document.location.href="/"
				} else{
					alert("다시 시도해주세요.");
				}
			}).catch(err => {
				alert("서버 오류 다시 시도해주세요");
			})
	}
});
// 비회원 게시글 수정버튼
/*$("#nmBoardUpdate").on("click", function() {
	
	bootbox.prompt({
	    title: "게시글 비밀번호를 입력해주세요",
	    inputType: 'password',
	    callback: function (result) {
	     
		console.log(result)
	    

		
		let bNo = $("#boardNo").val();
		let nowPage = $("#nowPage").val();
		
		const params = new URLSearchParams();
		
		params.append("nmPassword", result);
		params.append("BOARD_NO", bNo);
		
		axios.post("/mmPwdCheck.bo", params)
			.then( res => {
				if(res.data){
					alert("비밀번호가 일치합니다.");
					location.href="/updatePage.bo?bNo="+bNo+'&nowPage='+nowPage
				} else{
					alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
				}
			}).catch(err => {
				alert("서버 오류 다시 시도해주세요");
			})

		}
	});	  
});*/




// 비회원 게시글 삭제 버튼
/*$("#nmBoardDelete").on("click", function() {
		
		// bootbox password 타입 입력창 띄우기
		bootbox.prompt({
	    title: "게시글 비밀번호를 입력해주세요",
	    inputType: 'password',
	    callback: function (result) {
	     
		let bNo = $("#BOARD_NO").val();
		let nowPage = $("#nowPage").val();
		
		const params = new URLSearchParams();
		
		params.append("nmPassword", result)
		params.append("BOARD_NO", bNo)
		
		axios.post("/mmPwdCheck.bo", params)
			.then( res => {
				if(res.data){
					alert("비밀번호가 일치합니다.");
					
					if(confirm("정말로 삭제하시겠습니까?")){
		
						axios.post("/deleteBoard.bo", params)
							.then( res => {
								if(res.data > 0){
									alert("삭제 성공!.");
									document.location.href="/"
								} else{
									alert("다시 시도해주세요.");
								}
							}).catch(err => {
								alert("서버 오류 다시 시도해주세요");
						})
					}
				} else{
					alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
				}
			}).catch(err => {
				alert("서버 오류 다시 시도해주세요");
			})

		}
	});	
});
*/
// 비회원 수정버튼 클릭시
 $("#nmBoardUpdate").click(function(){
	$("#popup").css('display','flex').hide().fadeIn();
	$("#modalPWd2").val('');
 });

 // 확인버튼 비회원 게시글 수정
$("#confirm").click(function(){
	
    //컨펌 이벤트 처리
    modalClose();
    
    let pwd = $("#modalPWd").val();
    let bNo = $("#BOARD_NO").val();
	let nowPage = $("#nowPage").val();
		
	const params = new URLSearchParams();
		
	params.append("nmPassword", pwd);
	params.append("BOARD_NO", bNo);
	params.append("nowPage", nowPage);
	
    // 비밀번호 체크
	axios.post("/mmPwdCheck.bo", params)
		.then( function(res) {
			if(res.data){
				/*location.href="/updatePage.bo?bNo="+bNo+'&nowPage='+nowPage*/
				$('#updateForm').submit();
			} else{
				alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
			}
		}).catch(err => {
			alert("서버 오류 다시 시도해주세요");
		});
  });
  // 취소버튼
  $("#close").click(function(){
      modalClose();
  });
  
  function modalClose(){
    $("#popup").fadeOut();
  }
  



// 비회원 삭제버튼 클릭시
 $("#nmBoardDelete").click(function(){
	$("#popup2").css('display','flex').hide().fadeIn();
	$("#modalPWd2").val('');
 });
 // 확인버튼
$("#confirm2").click(function(){
	
    //컨펌 이벤트 처리
    modalClose2();
    
    var pwd = $("#modalPWd2").val();
    let bNo = $("#BOARD_NO").val();
		
	const params = new URLSearchParams();
		
	params.append("nmPassword", pwd);
	params.append("BOARD_NO", bNo);
	
    // 비밀번호 체크
	axios.post("/mmPwdCheck.bo", params)
			.then( function(res) {
				if(res.data){
					
					if(confirm("정말로 삭제하시겠습니까?")){
		
						axios.post("/deleteBoard.bo", params)
							.then( res => {
								if(res.data > 0){
									alert("삭제 성공!.");
									document.location.href="/"
								} else{
									alert("다시 시도해주세요.");
								}
							}).catch(function(err) {
								alert("서버 오류 다시 시도해주세요");
						})
					}
				} else{
					alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
				}
			}).catch(err => {
				alert("서버 오류 다시 시도해주세요");
		})
  });
    // 취소버튼 누르면 모달 닫기
  $("#close2").click(function(){
      modalClose2();
  });
  // 모달 닫는 함수
   function modalClose2(){
    $("#popup2").fadeOut();
    
  }


  
  // 댓글 작성
  $("#commentInsertBtn").on("click", function() {
	
	let board_No = $("#BOARD_NO").val();
	let comment_Content = $("#content").val();
	
	if(comment_Content==''){
		alert("내용을 입력해주세요.");
		return;
	}
	
	const params = new URLSearchParams();
	
	params.append("board_No", board_No);
	params.append("comment_Content", comment_Content);
	
	axios.post("insertComment.do", params)
		.then( function(res) {
			if(res.data){
				alert("댓글작성 성공!");
				location.reload();
			}
		}).catch(err => {
			alert("서버 오류 다시 시도해주세요");
		});
	
  });
  // 답글쓰기 버튼 클릭시 보이고 감추기
  $("[id^=rreply]").on("click", function() {
		let id = $(this)[0].id
		$("#r"+id).toggle();
		
		
  });
  
  // 대댓글 작성
  
  $("[id^=rcommentInsertBtn]").on("click", function() {
		
		let id = $(this)[0].id;
		let no = id.replace(/[^0-9]/g,'');
		
		let boardNo = $("#BOARD_NO").val();
		let commentNo = $("#cNo"+no).val();
		let commentContent = $("#rrcontent"+no).val();
		let comment_Parent = $("#comment_Parent"+no).val();
		let comment_Depth = $("#comment_Depth"+no).val();
		let comment_Order = $("#comment_Order"+no).val();
		let comment_Group = $("#comment_Group"+no).val();
		
		if(commentContent==''){
			alert("내용을 입력해주세요.");
		return;
	}
		
		const params = new URLSearchParams();
		
		params.append("board_No", boardNo);
		params.append("comment_Content", commentContent);
		params.append("comment_No", commentNo);
		params.append("comment_Parent", comment_Parent);
		params.append("comment_Depth", comment_Depth);
		params.append("comment_Order", comment_Order);
		params.append("comment_Group", comment_Group);
		
		
		
		axios.post("insertReComment.do", params)
				.then( function(res) {
					if(res.data){
						alert("댓글작성 성공!");
						location.reload();
					}
				}).catch( function(err) {
					alert("서버 오류 다시 시도해주세요");
				});
 	 });
 	 
$("[id^=rreplyUpdate]").on("click", function() {
	
		let id = $(this)[0].id;
		let no = id.replace(/[^0-9]/g,'');
		console.log(no);
		
		$("#rcontent"+no).attr('readonly', false);
		$("#rcontent"+no).focus();
		$("#commentUpdateBtn"+no).show();
});

$("[id^=commentUpdateBtn]").on("click", function() {
		let id = $(this)[0].id;
		let no = id.replace(/[^0-9]/g,'');
		console.log(no);
		
		let commentNo = $("#cNo"+no).val();
		let rcontent = $("#rcontent"+no).val();
		
		const params = new URLSearchParams();
		
		params.append("comment_Content", rcontent);
		params.append("comment_No", commentNo);
		console.log(params);
		
		axios.post("updateComment.do", params)
			.then( function(res) {
					if(res.data){
						alert("댓글수정 성공!");
						location.reload();
					}
				}).catch( function(err) {
					alert("서버 오류 다시 시도해주세요");
				});
		
});


$("[id^=rreplyDelete]").on("click", function() {
		
		result = window.confirm("삭제하시겠습니까?");
		
		if(!result){
			return;
		}
		
		let id = $(this)[0].id;
		let no = id.replace(/[^0-9]/g,'');
		
		let commentNo = $("#cNo"+no).val();
		
		const params = new URLSearchParams();
		
		params.append("comment_No", commentNo);
		console.log(params);
		
		axios.post("deleteComment.do", params)
			.then( function(res) {
					if(res.data){
						alert("댓글삭제 성공!");
						location.reload();
					}
				}).catch( function(err) {
					alert("서버 오류 다시 시도해주세요");
				});
		
});