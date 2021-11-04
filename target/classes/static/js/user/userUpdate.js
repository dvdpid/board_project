// 닉네임 중복 체크

$('#nickname').on('keyup', function() {
		
		let nickname = $(this).val().trim();
		let nowNick = $("#nowNick").val();
		if(nickname.length < 1) {
			$('.guide2').hide();
			
			return;
		}
		
		$.ajax({
			url: 'checkNickname.do',
			data: {USER_NICKNAME: nickname},
			success: function(data){
				console.log(data);
				if(data == '0' && data != nowNick){
					$('.guide.error').hide();
					$('.guide.ok2').hide();
					$('.guide.ok').show();
					$('#nickCHK').val(1);
				} else if(nickname == nowNick){
					$('.guide.ok2').show();
					$('.guide.ok').hide();
					$('.guide.error').hide();
					$('#nickCHK').val(1);
				} else{
					$('.guide.error').show();
					$('.guide.ok').hide();
					$('.guide.ok').hide();
					$('#nickCHK').val(0);
				}
			}
		});
});
$("#updateBtn").on("click", function() {
	
	// 닉네임 중복 체크 x
	if($('#nickCHK').val() == 0){
		alert('닉네임을 확인해주세요.');
		$('#nickname').focus();
		return;
	}
	// 닉네임을 입력 안했을 경우
	if($('#nickname').val() == ''){
		alert('닉네임을 확인해주세요.');
		$('#nickname').focus();
		return;
	}
	
	let nickname = $('#nickname').val();
	let uNo = $("#uNo").val();
	let phone = $("#phone").val();
	
	const params = new URLSearchParams();
	
	params.append("USER_NICKNAME", nickname);
	params.append("USER_NO", uNo);
	params.append("USER_PHONE", phone);
	
	
	axios.post("userUpdate.bo", params)
		.then(function(res) {
			if(res.data > 0){
				alert("정보 수정 성공!");
				location.href="/user/mypage.do"
			}
		}).catch( function(err) {
			alert("서버 오류 다시 시도해주세요");
	});
});

		