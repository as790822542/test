package com.tang.sericefeign.controller;

import com.tang.sericefeign.service.SchedualServiceHi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Method;

@RestController
public class HiController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Resource
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne( name );
    }

    @GetMapping(value = "/test")
    public void sayTest() {
        Object o = schedualServiceHi.sayHiFromClientTwo();
        Class<?> aClass = o.getClass();
        System.out.println(aClass);//FeignClient获取的对象会装换为LinkedHashMap；
        try {
//            Method getSsss = aClass.getMethod("Ssss");
//            Method getTest = aClass.getMethod("getTest");
//            getSsss.invoke(o);
//            getTest.invoke(o);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(o);
    }
}
