# base
基础web开发平台
2016-05-06 上传基础版本

spring mvc

mongodb

mybatis

分布式事务

activemq

redis

多线程

zookeeper

spring aop

定时任务

定时任务持久化

工厂方法

自定义注解

webservice  
客户端使用 wsimport -keep http://192.168.1.100:8888/WebService?wsdl"生成客户端代码 

远程调试步骤：
	1、在bin/startup.bat 文件中加入
		SET CATALINA_OPTS=-server -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8089
	   address端口好是自定义监控
	   
	2、配置Remote Java application 然后启动
	


url中含有中文解决方案：
	设置tomcat中的server.xml文件中的
	<Connector connectionTimeout="20000" port="8088" protocol="HTTP/1.1" redirectPort="8443" URIEncoding="UTF-8"/>


文件上传下载

xml bean之间的转换 	JAXB技术   参考文档 http://blog.sina.com.cn/s/blog_6fda308501013w2a.html


邮件发送 http://commons.apache.org/proper/commons-email/userguide.html


http工具类


树型菜单 http://www.htmleaf.com/jQuery/Menu-Navigation/201502141379.html

jetty 修改静态文件 热部署解决方案：
在web.xml中添加如下servlet 将useFileMappedBuffer 值设置为false
	<!-- 解决Jetty启动后不能修改静态文件问题 -->
	<servlet>
		<servlet-name>default</servlet-name>
		<servlet-class>org.mortbay.jetty.servlet.DefaultServlet</servlet-class>
		<init-param>
			<param-name>useFileMappedBuffer</param-name>
			<param-value> false </param-value>
		</init-param>
		<load-on-startup> 0 </load-on-startup>
	</servlet>
	
	
	
购物车 框架 simpleCart.js
http://www.zzbaike.com/wiki/SimpleCart(js)/%E5%AE%89%E8%A3%85%E5%8F%8A%E4%BD%BF%E7%94%A8


jquery ajax支持二进制 文件格式  			http://api.jquery.com/jquery.ajaxtransport/



mybatis 配置多数据源:
 方式1：创建两个mybatis的配置文件，多个SqlSessionFactory 这种方式不能共用mapper文件
 方式2：使用注解+aop实现动态数据源，更加注解切换不同的数据源 自己实现AbstractRoutingDataSource 接口
 参考http://blog.csdn.net/neosmith/article/details/61202084






