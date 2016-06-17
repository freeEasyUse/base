/**
 * ʹ��react �������ۿ��齨
 */

// ����һ���齨 ���������Ҫ��д ԭ����htmlԪ����ҪСд Ԫ�ص�class��Ҫд��className ��������state �޸� ��������Ⱦ�齨
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
		// �����齨��������������� ��������div������
		<div className="commentBox">
			<h1>Comments</h1>
			<CommentList data={this.state.data} />
			<CommentForm onCommentSubmit={this.handleCommentSubmit}/>
		</div>
		);
	}
	
});

// ����list
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

// jsx�﷨��{}�����Ű�סһ�� JavaScript ���ʽ��������Ϊ���Ի��߶��ӽڵ㣩
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



// ����fomr
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