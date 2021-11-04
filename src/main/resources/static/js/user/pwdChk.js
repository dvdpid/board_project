
/** 현재 비밀번호 확인 */

$("#nowPwd").on("keyup", function() {
	
	let nowPwd = $(this).val().trim();
	let uNo = $("#uNo").val();
	
	if(nowPwd.length < 2){
		$('.guide').hide();
		
		return;
	}
	
	// 현재 비밀번호 확인
	$.ajax({
			url: 'nowPwdCheck.bo',
			data: {
				USER_NO: uNo,
				pwd: nowPwd
			},
			success: function(data) {
				console.log(data);
				if(data){
					$('.guide.error').hide();
					$('.guide.ok').show();
					$('#pwdCHK').val(1);
				} else{
					$('.guide.error').show();
					$('.guide.ok').hide();
					$('#pwdCHK').val(0);
				}
			}
			
		});
});


// 새 비밀번호 , 새 비밀번호 확인 
$("#chkPwd").on("keyup", function() {
	
	let newPwd = $("#newPwd").val();
	let chkPwd = $(this).val().trim();
	
	if(newPwd == chkPwd){
		$('.guide2.error').hide();
		$('.guide2.ok').show();
		$('#pwdCHK2').val(1);
	} else{
		$('.guide2.error').show();
		$('.guide2.ok').hide();
		$('#pwdCHK2').val(0);
	}
	
});

$("#pwdBtn").on("click", function() {
	
	
	if($("#nowPwd").val() == ""){
		alert('현재 비밀번호를 확인해주세요.');
		$('#nowPwd').focus();
		return;
	}
	if($('#pwdCHK').val() == 0){
		alert('현재 비밀번호를 확인해주세요.');
		$('#nowPwd').focus();
		return;
	}
	if($('#pwdCHK2').val() == 0){
		alert('비밀번호가 일치하지 않습니다.');
		$('#newPwd').focus();
		return;
	}
	if($("#nowPwd").val() == $("#newPwd").val()){
		alert("현재 비밀번호랑 같습니다.");
		$('#newPwd').focus();
		return;
	}
	
	let pwd = $("#newPwd").val();
	let uNo = $("#uNo").val();
	
	const params = new URLSearchParams();
	
	params.append("USER_PWD", pwd);
	params.append("USER_NO", uNo);
	
	// 새 비밀번호 업데이트
	axios.post("pwdUpdate.do", params)
			.then(function(res) {
				if(res.data > 0){
					location.href="/user/mypage.do";
				} else {
					alert("다시 시도해주세요.");
				}
			}).catch(err => {
				alert("서버 오류 다시 시도해주세요");
	})
	
});
