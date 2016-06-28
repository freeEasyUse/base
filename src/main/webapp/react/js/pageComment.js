/**
 * 分页组件
 */


var PageComment = React.createClass({
	
	pageClick:function(e,originalEvent,type,page){
    	var pageInfo = new Object();
    	pageInfo.currentPage = page;
    	pageInfo.rowCount = this.props.rowCount;
    	pageInfo.searchConditon = this.props.searchConditon;
    	console.log(pageInfo);
    	this.setState(pageInfo);
    	console.log("json");
    	console.log(JSON.stringify(this.state));
	},
	
	
	getInitialState:function(){
		console.log(this.props.searchConditon);
		var pageInfo = new Object();
		pageInfo.rowCount = this.props.rowCount;
		pageInfo.currentPage = 1;
		pageInfo.searchConditon = this.props.searchConditon;
		console.log(pageInfo);
		return pageInfo;
	},
	
	render:function(){
		console.log("render");
		$.ajax({
  			url: this.props.url,
  			dataType: 'json',
  			contentType : "application/json",
  			type: 'POST',
  			data: JSON.stringify(this.state),
  			success: function(data) {
  				console.log(data);
				var r = $.parseJSON(data);
				var pageOption = r.result;
				var options = {
						bootstrapMajorVersion:3,
						currentPage: pageOption.currentPage,
						totalPages: pageOption.totalPages,
						numberOfPages:pageOption.numberOfPages,
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


var search = new Object();
search.name = "jonh";
search.age = 23;
ReactDOM.render(<PageComment url = {"/base/pageInfo/getIndex"} rowCount = {10} searchConditon={search}/>,$("#pageCommon").get(0));	