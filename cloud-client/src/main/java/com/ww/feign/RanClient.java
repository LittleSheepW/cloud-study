package com.ww.feign;

import com.ww.feign.hystrix.impl.RanClientHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * RanController FeignClient.
 *
 * @author: Sun
 * @create: 2019-04-25 10:19
 * @version: v1.0
 */
@FeignClient(value = "ww-server", fallback = RanClientHystrixImpl.class)
public interface RanClient {

	/**
	 * 通过id获取Ran
	 *
	 * @param: id
	 * @throws:
	 * @return: void
	 * @author: Sun
	 * @date: 2019-04-25 14:11
	 */
	@RequestMapping(value = "/ran/get/{id}")
	void getRanById(@PathVariable String id);

}