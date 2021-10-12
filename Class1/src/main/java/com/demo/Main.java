package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
class ProductManagerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(ProductManagerApplication.class, args);
        Student student = applicationContext.getBean(Student.class);
        student.show();

      /*  Address addres = applicationContext.getBean(Address.class);
        addres.showAddress();*/
    }

}