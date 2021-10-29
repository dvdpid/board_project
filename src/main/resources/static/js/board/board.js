
// 글쓰기 버튼 누르면
 $("#InsertBoard").on("click", function() {
	location.href="/insertPage.bo"
});

$("#searchBtn").on("click", function() {
	
	
	
	let searchType = $('#searchType').val();
	let keyword = $('#keyword').val();
		
	if(keyword == ""){
		alert("검색어를 입력해주세요.");
		return;
	}
	
	location.href="searchBoard.bo?searchType="+searchType+"&keyword="+keyword;
	
});
