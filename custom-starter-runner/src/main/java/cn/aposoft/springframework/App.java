package cn.aposoft.springframework;

import cn.aposoft.springboot.starter.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 */

@SpringBootApplication
public class App {


    @Component
    public static class CityService {
        private City city;

        @Autowired
        public void setCity(City city) {
            this.city = city;
        }

        public City getCity() {
            return this.city;
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello World!");
        ConfigurableApplicationContext context = SpringApplication.run(App.class);
        CityService service = context.getBean(CityService.class);
        System.out.println("city:" + service.getCity());
        context.close();
    }
}
