### Study SpringCloud framework.  
  
Start learning the SpringCloud framework. Record the receipt.

* **项目结构**
> `cloud-study`  聚合工程父工程
>> `cloud-eureka`  Eureka服务端工程  
>> `cloud-client`  Eureka客户端 调用服务的客户端，此客户端调用另一客户端(服务端)    
>> `cloud-server`  Eureka客户端 被调用服务的客户端(服务端),此工程提供一个对外的接口，由cloud-client来进行调用。  
  
###### 阶段历程  
* 第一阶段：项目中集成Eureka组件，服务与服务之前通过`RestTemplate+Ribbon` **/** `Feign` 进行调用。   
    
    