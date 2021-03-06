package com.ww.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Config class.
 * @author: Sun
 * @create: 2019-04-25 10:35
 * @version: v1.0
 */
@Configuration
public class ConfigBean {

    /**
     * Give the RestTemplate to the Spring container to manage.
     * 如果不加入@LoadBalanced注解在程序被调用时会抛出UnknownHostException异常,
     * RestTemplate能通过服务名获取到具体的服务是由LoadBalancerInterceptor这个拦截器实现的，而具体的是由RibbonLoadBalancerClient来实现的。
     * RibbonLoadBalancerClient将服务名通过负载均衡策略转为了实际的ip和端口后再apply给restTemplate。
     * 如果不加@LoadBalanced注解那么无法将服务名转换为实际的ip和端口，所以会抛出异常。
     *
     * 实际上利用了RestTemplate的拦截器，使用RestTemplateCustomizer对所有标注了@LoadBalanced的RestTemplate Bean添加了
     * 一个LoadBalancerInterceptor拦截器，而这个拦截器的作用就是对请求的URI进行转换获取到具体应该请求哪个服务实例ServiceInstance。
     * {@link org.springframework.cloud.client.loadbalancer.LoadBalancerAutoConfiguration} loadBalancedRestTemplateInitializerDeprecated（）
     *
     * @param factory
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate getRestTemplate(ClientHttpRequestFactory factory) {
        // 注入的同时为其设置超时时间
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        // 数据读取超时时间
        factory.setReadTimeout(5000);
        // 连接超时时间
        factory.setConnectTimeout(5000);
        return factory;
    }

    /**
     * 自定义Ribbon负载均衡策略，默认为轮询策略
     * @return
     */
    /*@Bean
    public IRule myRule() {
        return new RandomRule();
    }*/
}
