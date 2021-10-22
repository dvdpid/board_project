
// 글쓰기 버튼 누르면
 $("#InsertBoard").on("click", function() {
	location.href="/insertPage.bo"
});

$("#searchBtn").on("click", function() {
	
	
	
	let type = $('#searchType').val();
	let keyword = $('#keyword').val();
		
	if(keyword == ""){
		alert("검색어를 입력해주세요.");
		return;
	}
	
	location.href="searchBoard.bo?type="+type+"&keyword="+keyword;
	
});
/*$("#searchDetail").on("click", function() {
	let type = $('#searchType').val();
	let keyword = $('#keyword').val();
	let nowPage = $('#nowPage').val();
	let boardNo = $('#boardNo').val();
	
	console.log(type);
	console.log(keyword);
	console.log(nowPage);
	console.log(boardNo);
	
	
	location.href='/boardDetail.bo?BOARD_NO='+ boardNo +'&nowPage='+nowPage+'&type='+type+'&keyword='+keyword;
});*/