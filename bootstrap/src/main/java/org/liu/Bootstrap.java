package org.liu;


import jakarta.annotation.PostConstruct;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Map;

@MapperScan(basePackages = {"org.liu.dal"})
//@ComponentScan(basePackages = {"org.liu.controller","org.liu.service","org.liu.dal","org.liu.model"})
@SpringBootApplication(scanBasePackages = {"org.liu.controller","org.liu.service","org.liu.dal","org.liu.model"})
public class Bootstrap {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    public static void main(String[] args){
        ConfigurableApplicationContext context = SpringApplication.run(Bootstrap.class,args);
        System.out.println(context.getBeansWithAnnotation(Controller.class));
    }

    @PostConstruct
    public void init() {
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        map.keySet().forEach(mapping -> {
            mapping.getPatternsCondition().getPatterns().forEach(System.out::println);
        });
    }
}
