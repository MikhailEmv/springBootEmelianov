package com.example.springBootEmelianov.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig implements WebSecurityConfigurer<WebSecurity> {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    public void init(WebSecurity builder) throws Exception {

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/public/api");
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/api").hasRole("ADMIN")
                .antMatchers("/support/api").hasRole("SUPPORT")
                .and().httpBasic()
                .and().csrf().disable();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        User.UserBuilder userBuilder = User.builder().passwordEncoder(passwordEncoder::encode);
        UserDetails admin = userBuilder.username("admin").password("password").roles("ADMIN").build();
        UserDetails support = userBuilder.username("support").password("password").roles("SUPPORT").build();
        return new InMemoryUserDetailsManager(admin, support);
    }
}
