package com.example.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 通过@EnableDiscoveryClient向服务中心注册；并且向程序的ioc注入一个bean: restTemplate;
 * 通过@LoadBalanced注解表明这个restRemplate开启负载均衡的功能。
 * 通过@EnableHystrix开启断路器
 * 断路器：在分布式服务中，如果一个服务的提供节点坏掉，会导致调用这个服务的线程阻塞，此时如果有大量的线程涌入
 * 			会导致servlet的线程资源消耗完毕，导致服务瘫痪。服务与服务之间的依赖性即，故障就会传播，对整个
 * 			微服务系统造成灾难性的后果，这个就是服务的血崩效应。。当对特定的服务的调用的不可用达到一个阀值
 * 			（Hystric 是5秒20次） 断路器将会被打开。在这个节点上启动一个Fallback，使请求返回固定的值
 * 			断路打开后，可用避免连锁故障，fallback方法可以直接返回一个固定值。
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
