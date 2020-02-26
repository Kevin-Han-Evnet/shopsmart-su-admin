package com.fiveone.shopsmart.suadmin;

import com.fiveone.shopsmart.suadmin.config.SessionListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.servlet.http.HttpSessionListener;

@EnableJpaAuditing
@SpringBootApplication
public class SuAdminApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(SuAdminApplication.class, args);
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SuAdminApplication.class);
    }

    @Bean
    public HttpSessionListener httpSessionListener(){
        return new SessionListener();
    }
}
