package com.senai.inmind.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.senai.inmind.services.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginEntryPoint loginEntryPoint;

    @Bean
    public AuthenticationManager getAuthenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(userService).passwordEncoder(encoder());

        var authenticationManager = builder.build();

        http.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(HttpMethod.POST, "/psychologists").permitAll()
                        .requestMatchers(HttpMethod.POST, "/patients").permitAll()
                        .requestMatchers(HttpMethod.POST, "/avaliation").permitAll()
                        .requestMatchers(HttpMethod.POST, "/schedulings").permitAll()
                        .requestMatchers(HttpMethod.POST, "/addresses").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/refresh").permitAll()
                        .requestMatchers(HttpMethod.GET, "/psychologists").permitAll()
                        .requestMatchers(HttpMethod.GET, "/psychologists/{id}").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/psychologists").permitAll()
                        .requestMatchers(HttpMethod.GET, "/patients/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/patients").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/patients").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/psychologists").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/patients").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/schedulings").permitAll()
                        .requestMatchers(HttpMethod.GET, "/addresses/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/addresses").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/addresses").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/addresses").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/avaliation").permitAll()
                        .requestMatchers(HttpMethod.GET, "/avaliation/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/avaliation").permitAll()
                        .requestMatchers(HttpMethod.GET, "/schedulings/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/schedulings").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/schedulings").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v3/api-docs/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/**").permitAll()
                        .anyRequest().authenticated())
                .authenticationManager(authenticationManager)
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(handling -> handling
                        .authenticationEntryPoint(loginEntryPoint)
                        .accessDeniedHandler(new AccessDeniedHandlerImpl()));

        return http.build();
    }
}