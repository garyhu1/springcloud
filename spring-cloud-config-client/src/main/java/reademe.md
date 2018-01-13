# 使用/refresh端点手动刷新配置
1、在Controller上添加注解@RefreshScope
2、运行项目后，修改配置文件，重新访问会发现并没有改变，这时需要操作：
   发送POST请求到http://localhost:8071/refresh:
   curl -X POST http://localhost:8071/refresh
   返回结果： "profile",表示profile这个配置属性已被刷新
3、再次访问就可以看到改变了   

# 使用Spring Cloud Bus自动刷新配置
1、安装RabbitMQ
## 先安装Erlang/OTP 19.2
   因为RabbitMQ依赖于这个
 http://www.erlang.org/downloads
## 安装RabbitMQ
 http://www.rabbitmq.com/install-windows.html 
   