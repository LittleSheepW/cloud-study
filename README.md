### Study SpringCloud framework.  
  
Start learning the SpringCloud framework. Record the receipt.

* **项目结构**
> `cloud-study`  聚合工程父工程
>> `cloud-eureka-6868、6869、6870`  Eureka服务端集群  
>> `cloud-client`  Eureka客户端 调用服务的客户端，此客户端调用另一客户端(服务端)    
>> `cloud-server-8081、8082、8083`  Eureka客户端集群 被调用服务的客户端(服务端)，每个服务对应自己的数据库。
  
###### 阶段历程    
* 第一阶段：项目中集成Eureka组件并搭建Eureka集群。
* 第二阶段：项目中集成Ribbon客户端负载均衡组件，服务与服务之间通过RestTemplate进行相互调用。
* 第三阶段：项目中集成Feign组件，完成对服务提供方接口绑定，简化使用Ribbon，面向接口调用服务。
* 第四阶段：项目中集成Hystrix组件，防止对某一个故障服务持续访问引起服务雪崩现象。 
* 第五阶段：项目中集成Hystrix Dashboard组件，监控服务情况。
* 第六阶段：项目中集成Zuul组件，所有请求通过服务网关进行转发。 
* 第七阶段：项目中集成swagger组件，cloud-server-8081项目可以根据接口自动生成接口文档。
* 第八阶段：项目中集成Config组件，将cloud-client服务配置文件application.yml托管至gitee仓库，搭建cloud-config-server服务，启动cloud-client项目时动态从git仓库中拉取对应配置文件。
* 第九阶段：项目中集成sleuth'组件，构建链路追踪机制。