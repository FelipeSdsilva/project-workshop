package com.project.workshop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.Arrays;

@Configuration
public class ResourceServerConfig  {

    @Autowired
    private Environment env;

    public void configure(HttpSecurity http) throws Exception {

        //This configure liberation h2 console route
        if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .anyRequest().permitAll()
                .anyRequest().authenticated();
    }


}
