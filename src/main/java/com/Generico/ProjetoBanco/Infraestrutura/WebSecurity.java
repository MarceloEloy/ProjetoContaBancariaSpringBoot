package com.Generico.ProjetoBanco.Infraestrutura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurity {

    @Autowired
    SecurityFilter securityFilter;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

     httpSecurity.csrf(csrf -> csrf.disable())
             .sessionManagement(maager -> maager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
             .authorizeHttpRequests(auth -> auth.
                     requestMatchers(HttpMethod.POST, "/Login/log").permitAll()
                     .requestMatchers(HttpMethod.POST, "/Login/reg").permitAll()
                     .requestMatchers(HttpMethod.POST, "/Categoria").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.POST, "/Lancamento").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.POST, "/Pessoa").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.PUT, "/Categoria").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.PUT, "/Lancamento").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.PUT, "/Pessoa").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.DELETE, "/Categoria").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.DELETE, "/Lancamento").hasRole("ADMIN")
                     .requestMatchers(HttpMethod.DELETE, "/Pessoa").hasRole("ADMIN")
                     .anyRequest().hasRole("BASIC"))
             .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
