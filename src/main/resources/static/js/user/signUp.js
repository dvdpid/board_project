let main = () => {
	 // 로고 클릭시 메인화면으로 이동
	 $("#logo").on("click", function() {
		location.href="/"
	});
		
		
	// 회원가입
	$("#updateBtn").on("click", function() {
		
		const params = new URLSearchParams();
		
		params.append('USER_ID', $('#userId').val());
		params.append('USER_PWD', $('#userpwd1').val());
		params.append('USER_NICKNAME', $('#nickname').val());
		params.append('USER_PHONE', $('#phone').val());
		
		
		axios.post("/user/signUp.do", params)
			.then( result  => {
				if(result === 1){
					location.href="/user/login.do"
				} else{
					alert("회원가입에 실패하셨습니다. 다시 시도해주세요");
				}
			})
			
	});
	
}
main();