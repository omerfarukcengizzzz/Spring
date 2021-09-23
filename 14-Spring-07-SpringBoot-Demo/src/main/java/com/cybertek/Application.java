package com.cybertek;

import com.cybertek.interfaces.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// if you add the scanBasePackages parameter, it will override the default scan package
@SpringBootApplication(scanBasePackages = "com.cybertek")
public class Application {

    public static void main(String[] args) {

        ApplicationContext container = SpringApplication.run(Application.class, args);

        Course course = container.getBean("java", Course.class);

        course.getTeachingHours();

    }

}
