let main = () => {
	
	// 로그인 버튼 클릭시 로그인 페이지로 이동
	$("#login").on("click", function() {
		location.href="/user/loginPage.do"
	});
	$("#siginUp").on("click", function() {
		location.href="/user/signUpPage.do"
	});
	$("#logo").on("click", function() {
		location.href="/"
	});
}

main();

