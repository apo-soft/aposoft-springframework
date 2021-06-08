package cn.aposoft.springframework.scan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfiguration {

    public SimpleConfiguration() {
        System.out.println("SimpleConfiguration is created.");
    }

    @Bean
    public Bicycle bicycle() {
        Bicycle bicycle = new Bicycle();
        bicycle.setName("feige");
        return bicycle;
    }

}
