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
