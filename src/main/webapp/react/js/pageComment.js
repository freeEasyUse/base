/**
 * 分页组件
 */


var PageComment = React.createClass({
	
	pageClick:function(e,originalEvent,type,page){
		console.log('onPageClicked');
		console.log(this.state);
    	var pageInfo = new Object();
    	pageInfo.pageIndex = page;
    	pageInfo.rowCount = 10;
    	this.setState(pageInfo);
	},
	
	
	getInitialState:function(){
		var pageInfo = new Object();
		pageInfo.rowCount = this.props.rowCount;
		pageInfo.pageIndex = 1;
		return pageInfo;
	},
	
	render:function(){
		$.ajax({
  			url: this.props.url,
  			dataType: 'json',
  			type: 'POST',
  			data: this.state,
  			success: function(data) {
				var r = $.parseJSON(data);
				var pageOption = r.result;
				console.log(pageOption);
				
				var options = {
						bootstrapMajorVersion:3,
						currentPage: pageOption.pageIndex,
						totalPages: pageOption.allCount,
						numberOfPages:10,
						size:"normal",
			            alignment:"center",
			        	itemTexts:function (type, page, current) {
			        		console.log("item"+type);
			                switch (type) {
			                case "first":
			                    return "首页";
			                case "prev":
			                    return "前一页";
			                case "next":
			                    return "下一页";
			                case "last":
			                    return "尾页";
			                case "page":
			                    return "第"+page+"页";
			                }
			            },
			            onPageClicked:this.pageClick
					}
			   $('#pageCommon').bootstrapPaginator(options);
				
  			}.bind(this),
  			error: function(xhr, status, err) {
    			console.error(this.props.addUrl, status, err.toString());
  			}.bind(this)
		});
		return null;
	},
});



ReactDOM.render(<PageComment url = {"/base/pageInfo/getIndex"} rowCount = {10}/>,$("#pageCommon").get(0));	