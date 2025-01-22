package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    //without encoding the password
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.builder().username("piyush").password("abc").roles("admin").build();
//        UserDetails user1 = User.builder().username("prajwal").password("xyz").roles("admin").build();
//        return new InMemoryUserDetailsManager(user,user1);
//    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder().username("piyush").password(passwordEncoder().encode("abc")).roles("admin").build();
        UserDetails user1 = User.builder().username("prajwal").password(passwordEncoder().encode("xyz")).roles("admin").build();
        return new InMemoryUserDetailsManager(user,user1);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
