/**
 * һ������: React ���ֻ����Ⱦ�������ڵ㡣�������Ҫ���ض���ڵ㣬���Ǳ��뱻������ͬһ���ڵ��
 * ���� hello �� it ��Ҫ������p��
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