package com.example.cruddemo;

import com.example.cruddemo.person.Person;
import com.example.cruddemo.service.HomeService;
import com.example.cruddemo.service.PersonService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    @Autowired
    PersonService personService;

    @Autowired
    HomeService homeService1;


    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CrudDemoApplication.class, args);
        Object homeService = run.getBean("homeService");
        HomeService homeService2 = (HomeService) homeService;

    }

    @PostConstruct
    public void hello() {

    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                System.out.println("Hello");
                Person saketh = new Person();
                saketh.setAge(23);
                saketh.setName("Saketh");
                personService.addPerson(saketh);

                homeService1.home();

            }
        };
    }


}
