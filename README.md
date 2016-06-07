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
	
文件上传下载
http工具类