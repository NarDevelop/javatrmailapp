package com.java.javatr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)

public class JavatrApplication {

    public static void main( String[] args ) {
        SpringApplication.run( JavatrApplication.class, args );
    }

}
