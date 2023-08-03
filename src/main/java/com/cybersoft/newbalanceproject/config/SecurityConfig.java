package com.cybersoft.newbalanceproject.config;

import com.cybersoft.newbalanceproject.filter.JwtFilter;
import com.cybersoft.newbalanceproject.provider.CustomAuthenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Autowired
    private CustomAuthenProvider customAuthenProvider;
    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(customAuthenProvider)
                .build();

    }

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
        return http.csrf().disable() // Tắt cấu hình liên quan tới tấn công csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Khai báo không sử dụng session trong project
                .and()
                .authorizeHttpRequests() //Quy định lại các rule liên quan đến chứng thực cho link được gọi
                .antMatchers("/signin", "/signup","/ws/**").permitAll()
                .antMatchers("/customer/**").hasAuthority("ROLE_ADMIN")
                .antMatchers("/message/private-message").hasAuthority("ROLE_CUSTOMER")
                .anyRequest().authenticated() //Tất cả các link còn lại đều phải chứng thực
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
