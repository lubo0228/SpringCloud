package com.forezp.controller;

import com.forezp.feign.SchedualServiceHi;
import com.forezp.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiFeignController {

    @Autowired
    SchedualServiceHi schedualServiceHi;
    @Autowired
    FeignService feignService;

    @GetMapping(value = "/hi-feign")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping("/txlcn")
    public void txlcn() {
        feignService.txlcn();
    }
}
