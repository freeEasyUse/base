/**
 * 一个限制: React 组件只能渲染单个根节点。如果你想要返回多个节点，它们必须被包含在同一个节点里。
 * 所以 hello 和 it 需要包含在p中
 */

var SayTime = React.createClass({
	render:function(){
		return(
			<p>
				hello,<input type="text" placeholder="your name"/>
				It is {this.props.data.toTimeString()}
			</p>
		);
	}
});

setInterval(function(){
	ReactDOM.render(<SayTime data={new Date()}/>,document.getElementById("container"))
},500)