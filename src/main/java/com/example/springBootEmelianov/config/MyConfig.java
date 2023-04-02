package com.example.springBootEmelianov.config;
import com.example.springBootEmelianov.beans.MyConditionalBean;
import com.example.springBootEmelianov.beans.MyConditionalPropertyBean;
import com.example.springBootEmelianov.beans.MyTestBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class MyConfig {

    @Bean
    @Profile("test")
    public MyTestBean myTestBean() {
        return new MyTestBean();
    }

    @Bean
    @ConditionalOnBean(MyTestBean.class)
    public MyConditionalBean myConditionalBean() {
        return new MyConditionalBean();
    }

    @Bean
    public MyConditionalPropertyBean myConditionalPropertyBean(Environment env) {
        var exampleTest = env.getProperty("example.test");
        if (!"default".equals(exampleTest)) {
            return new MyConditionalPropertyBean();
        }
        return null;
    }
}

