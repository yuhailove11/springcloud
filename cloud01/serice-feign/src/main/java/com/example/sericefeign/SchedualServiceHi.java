package com.example.sericefeign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign接口，通过@ FeignClient（“服务名”），
 * 来指定调用哪个服务。比如在代码中调用了service-hi服务的“/hi”接口
 * fallback 用来指定断路器的fallback所在的类。这个类要实现此接口
 */
@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
@Component
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
