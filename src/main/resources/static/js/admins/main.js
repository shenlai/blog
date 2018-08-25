
// DOM 加载完再执行
$(function() {

	// 搜索
	$(".blog-menu .list-group-item").click(function() {

		//移除其他点击样式，添加当前的点击样式
		$(".blog-menu .list-group-item").removeClass("active");
		$(this).addClass("active");
		
		var url = $(this).attr("url");
		//加载表格内容
		$.ajax({
			url:url,
			success:function(data){
				$("#rightContainer").html(data);
			},
			error:function(){
				alert("error");
			}
		});
		
	});
	
	//选中菜单第一页
	$(".blog-menu .list-group-item:first").trigger("click");
});