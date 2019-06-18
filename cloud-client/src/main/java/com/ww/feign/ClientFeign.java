package com.ww.feign;

import com.ww.hystrix.impl.ClientFeignHystrixImpl;
import com.ww.pvo.StudentPvo;
import com.ww.vo.StudentVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * ClientController FeignClient.
 *
 * Hystrix熔断器，使用Hystrix有两种方式 (两种方式均要在启动类中加入@EnableHystrix注解)
 * 第一种是pom文件中加入Hystrix本身的依赖，然后在调用的方法上加入@HystrixCommand(fallbackMethod = "getBanByRestTemplateError")注解，fallbackMethod是断路触发方法。
 *
 * 第二种是pom文件中加入Feign的依赖，然后再加入Hystrix的依赖并且在yml配置文件中设置feign.hystrix.enabled = true。
 * 重写FeignClient接口的方法，将重写的类交由Spring容器管理。FeignClient接口类注解@FeignClient中加入属性fallBack = FeignClient实现类.class即可。
 *
 * Feign集成Hystrix的时候遇到两个问题：
 *   1、加入@EnableHystrix的时候启动会报错，Feign默认集成了Hystrix，但是Hystrix的核心依赖并没有集成，所以还要在pom文件中加入Hystrix的依赖。
 *   2、在application.yml文件中设置feign.hystrix.enabled = true时没有提示。不用管他启动照样生效。
 *
 * @author: Sun
 * @create: 2019-04-25 10:19
 * @version: v1.0
 */
@FeignClient(value = "CLOUD-SERVER", fallback = ClientFeignHystrixImpl.class)
public interface ClientFeign {

	/**
	 * 通过id获取Student
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/student/{id}")
	StudentVo getStudentById(@PathVariable(value = "id") Integer id);

	/**
	 * 保存学生
	 * @param studentPvo
	 * @return
	 */
	@RequestMapping(value = "/student")
	StudentVo saveStudent(StudentPvo studentPvo);

	/**
	 * 查询学生列表
	 * @return
	 */
	@RequestMapping(value = "/student")
	List<StudentVo> getStudentList();

}