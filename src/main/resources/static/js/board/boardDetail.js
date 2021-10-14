
// 수정 버튼 클릭시 수정 페이지로
$("#boardUpdate").on("click", function(){
	
	let bNo = $("#boardNo").val();
	let nowPage = $("#nowPage").val();
	
	location.href="/updatePage.bo?bNo="+bNo+'&nowPage='+nowPage
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
$("#nmBoardUpdate").on("click", function() {
	
	bootbox.prompt({
	    title: "게시글 비밀번호를 입력해주세요",
	    inputType: 'password',
	    callback: function (result) {
	     
		console.log(result)
	    

		
		let bNo = $("#boardNo").val();
		let nowPage = $("#nowPage").val();
		
		const params = new URLSearchParams();
		
		params.append("nmPassword", result)
		params.append("BOARD_NO", bNo)
		
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
});

// 비회원 게시글 삭제 버튼
$("#nmBoardDelete").on("click", function() {
		
		// bootbox password 타입 입력창 띄우기
		bootbox.prompt({
	    title: "게시글 비밀번호를 입력해주세요",
	    inputType: 'password',
	    callback: function (result) {
	     
		let bNo = $("#boardNo").val();
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
