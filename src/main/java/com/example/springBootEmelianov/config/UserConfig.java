package com.example.springBootEmelianov.config;

import com.example.springBootEmelianov.beans.user.InsolventUser;
import com.example.springBootEmelianov.beans.user.SolventUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class UserConfig {

    @Bean
    @Scope (value = "prototype")
    public SolventUser solventUser() {
        return new SolventUser();
    }

    @Bean
    @Scope (value = "prototype")
    public InsolventUser insolventUser() {
        return new InsolventUser();
    }
}
