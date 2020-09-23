package com.tang.sericefeign.hystric;

import com.tang.sericefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public Object sayHiFromClientTwo() {
        return null;
    }
}
