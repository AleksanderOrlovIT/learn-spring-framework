package com.learnspringframework.examples.h1;

import com.learnspringframework.game.GameRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class YourBusinessClass{

    Dependency1 dependency1;
    Dependency2 dependency2;

    //@Autowired
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructor injection - Your business class");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString(){
        return "Using " + dependency1 + " and " + dependency2;
    }
}

@Component
class Dependency1{}

@Component
class Dependency2{}

@Configuration
@ComponentScan("com.learnspringframework.examples.h1")
public class XmlConfigurationContextLauncher {
    public static void main(String[] args) {
        try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml")){
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean("name"));
            context.getBean(GameRunner.class).run();
        }
    }
}
