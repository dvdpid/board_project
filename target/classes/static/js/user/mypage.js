// radio 버튼 선택 후 확인 버튼 눌렀을 경우

$("#btn").on("click", function() {
	
	let radio = $('input[name="modify"]:checked').val();
	let pwd = $("#pwd").val();
	let uNo = $("#uNo").val();
	
	
	// 비밀번호 체크
	if(pwd == ""){
		alert("비밀번호를 입력해주세요.");
		$("#pwd").focus();
		return;
	}
	// 만약 라디오 버튼이 체크가 안됐을경우
	if(radio ==""){
		alert("원하시는 항목을 체크를 해주세요.");
		return;
	}
	
	const params = new URLSearchParams();
	
	console.log(pwd);
	
	params.append("pwd", pwd);
	params.append("USER_NO", uNo);
	
	axios.post("userPwdCheck.bo", params)
			.then( function(res) {
				// 반환값이 true일 경우
				if(res.data){
					
					// 1 : 비밀번호 수정
					if(radio == 0){
						location.href="/user/pwdPage.do"
					}
					// 2 : 개인정보 수정 
					else if(radio == 1){
						location.href="/user/modifyPage.do"
					}
					// 3 : 회원 탈퇴 
					else if(radio == 2){
						if(confirm("정말로 탈퇴하시겠습니까?")){
							$('#deleteUser').submit();
						} else{
							return;
						}
					}
					
				} else {
					alert("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
				}
			}).catch( function(err) {
				alert("서버 오류 다시 시도해주세요");
	});
	
});

				