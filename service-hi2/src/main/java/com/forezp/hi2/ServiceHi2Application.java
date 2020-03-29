package com.forezp.hi2;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.forezp.hi2.service.Hi2Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.*;

@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableDistributedTransaction
public class ServiceHi2Application {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHi2Application.class, args);
    }

    @Value("${server.port}")
    String port;
    @Autowired
    private Hi2Service hi2Service;

    @GetMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }


    private String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

    @PostMapping("/save")
    @HystrixCommand(fallbackMethod = "saveError")
    public void save() {
        hi2Service.save();
    }

    private String saveError() {
        return "hi2sorry,error!";
    }

    @PostMapping("/save2")
    @HystrixCommand(fallbackMethod = "saveError")
    public void save2() {
        hi2Service.save();
    }
}
