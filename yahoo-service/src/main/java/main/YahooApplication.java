package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller")
public class YahooApplication {

    public static void main(String[] args) {
        SpringApplication.run(YahooApplication.class);
    }

}
