# config server的健康状况指示器
1、自带
2、/health
3、访问/health时，默认情况是向EnvironmentRepository请求的{application}是app,{profile}和{label}是对应EnvironmentRepository实现的默认值。对于Git，{profile}是default，{label}是master.
4、可以自定义健康指示器的配置：具体详见application.yml
5、如果想要禁用可设置：spring.cloud.config.server.health.enabled=false


# 