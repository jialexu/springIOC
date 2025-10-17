package com.chuwa.springbasic;

import com.chuwa.springbasic.components.JpaChuwa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbasicApplication.class, args);

        System.out.println("\n=== All JpaChuwa Beans ===");
        for (String name : context.getBeanNamesForType(JpaChuwa.class)) {
            System.out.println("- " + name);
        }

        System.out.println("\n=== Call Each Bean's printMessage() ===");
        context.getBeansOfType(JpaChuwa.class)
                .forEach((name, bean) -> {
                    System.out.print(name + " -> ");
                    bean.printMessage();
                });
    }
}
