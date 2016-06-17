/**
 * 使用react 创建评论框组建
 */

// 申明一个组建 组件名字需要大写 原生的html元素需要小写 元素的class需要写成className 自身属性state 修改 会重新渲染组建
var CommontBox = React.createClass({
	loadCommentsFromServer: function() {
	    $.ajax({
	      url: this.props.url,
	      dataType: 'json',
	      cache: false,
	      success: function(data) {
	    	var r = $.parseJSON(data);
	        this.setState({data: r.list});
	      }.bind(this),
	      error: function(xhr, status, err) {
	        console.error(this.props.url, status, err.toString());
	      }.bind(this)
	    });
	  },
	  handleCommentSubmit: function(comment) {
		  $.ajax({
		      url: this.props.addUrl,
		      dataType: 'json',
		      type: 'POST',
		      data: comment,
		      success: function(data) {
		    	var r = $.parseJSON(data);
			    this.setState({data: r.list});
		      }.bind(this),
		      error: function(xhr, status, err) {
		        console.error(this.props.addUrl, status, err.toString());
		      }.bind(this)
		    });
		  },
	getInitialState: function() {
		    return {data: []};
		  },
	componentDidMount: function() {
		 this.loadCommentsFromServer();
	},
	render:function(){
		return (
		// 调用组建必须包含在容器中 所有这里div不能少
		<div className="commentBox">
			<h1>Comments</h1>
			<CommentList data={this.state.data} />
			<CommentForm onCommentSubmit={this.handleCommentSubmit}/>
		</div>
		);
	}
	
});

// 评论list
var CommentList = React.createClass({
	render:function(){
		console.log(this.props.data);
		var commentNodes = this.props.data.map(function (comment) {
		      return (
		        <Comment author={comment.author}>
		          {comment.text}
		        </Comment>
		      );
		    });
		
		return(
			<div className="commentList">
			 	{commentNodes}
			</div>	
		);

	}
});

// jsx语法中{}大括号包住一个 JavaScript 表达式（例如作为属性或者儿子节点）
var Comment = React.createClass({
	
	 rawMarkup: function() {
		    var rawMarkup = marked(this.props.children.toString(), {sanitize: true});
		    return { __html: rawMarkup };
		  },
	
	render:function(){
		return (
				<div className="comment">
					<h2 className="commentAuthor">
						{this.props.author}
					</h2>
					<span dangerouslySetInnerHTML={this.rawMarkup()} />
				</div>
		);
	}
	
});



// 评论fomr
var CommentForm = React.createClass({
	
	 handleSubmit: function(e) {
		    e.preventDefault();
		    var author = this.refs.author.value.trim();
		    var text = this.refs.text.value.trim();
		    if (!text || !author) {
		      return;
		    }
		    this.props.onCommentSubmit({author: author, text: text});
		    this.refs.author.value = '';
		    this.refs.text.value = '';
		    return;
		  },
	
	render:function(){
		return(
		  <form className="commentForm" onSubmit={this.handleSubmit}>
			   <input type="text" placeholder="Your name" ref="author" />
			   <input type="text" placeholder="Say something..." ref="text" />
	           <input type="submit" value="Post" />
	      </form>
		);
	}
});


ReactDOM.render(<CommontBox url="/base/react/getData" addUrl="/base/react/addComment"/>,document.getElementById("container"))
//ReactDOM.render(<CommontBox url="/base/react/getData" addUrl="/base/react/addComment" pollInterval={10000}/>,document.getElementById("container"))
//ReactDOM.render(<CommontBox url="/base/react/getData" pollInterval={2000}/>,document.getElementById("container"))