package com.forezp.remote;

import com.forezp.feign.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry " + name;
    }

    @Override
    public String execute() {
        return null;
    }

    @Override
    public String execute2() {
        return null;
    }
}
