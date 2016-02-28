package org.josescalia.blog.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by josescalia on 03/02/16.
 */
@Configuration
@ComponentScan(basePackages = {"org.josescalia.blog.simple"})
@EntityScan(basePackages = "org.josescalia.blog.simple.model")
@EnableJpaRepositories(basePackages = {"org.josescalia.blog.simple.repository"})
@EnableAutoConfiguration
@Component
public class SpringApps {

    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(SpringApps.class);
        application.run(args);

    }
}
