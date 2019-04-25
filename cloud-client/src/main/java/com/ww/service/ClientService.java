package com.ww.service;

/**
 * Client service interface.
 *
 * @author: Sun
 * @create: 2019-04-25 10:19
 * @version: v1.0
 */
public interface ClientService {

    /**
     * 获取Ran(通过RestTemplate进行服务调用)
     *
     * @param:
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:48
     */
    void getRanByRestTemplate();

    /**
     * 获取Ran(通过Feign进行服务调用)
     * @param:
     * @throws:
     * @return: void
     * @author: Sun
     * @date: 2019-04-25 11:48
     */
    void getRanByFeign();
}
