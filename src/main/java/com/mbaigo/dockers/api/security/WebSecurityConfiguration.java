package com.mbaigo.dockers.api.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;/*
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;*/

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
@Configuration/*
@EnableWebSecurity
@EnableMethodSecurity*/
public class WebSecurityConfiguration {

   /* private final AccountAuthenticationProvider accountAuthenticationProvider;

    public WebSecurityConfiguration(AccountAuthenticationProvider accountAuthenticationProvider) {
        this.accountAuthenticationProvider = accountAuthenticationProvider;
    }

    //Configuration des filtres de sécurités
    @Bean
    public SecurityFilterChain filterChaine(HttpSecurity http) throws Exception {
         http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(POST,"/api/accounts/**").permitAll()
                .requestMatchers( "/swagger-ui/index.html/**").permitAll()
                .requestMatchers(GET,"/api/accounts/**")
                .permitAll()
                .requestMatchers("/**")
                        .authenticated()
                                .anyRequest()
                                    .hasAnyRole("USER","ADMIN")
                                        .and()
                                            .authenticationProvider(accountAuthenticationProvider)
                                                .httpBasic(Customizer.withDefaults())
                                                    .sessionManagement()
                                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

                return http.build();

    }*/
//création des utilisateurs en mémoire
 /*   @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                               .username("user")
                               .password("pass")
                               .roles("USER")
                               .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                                .username("user")
                                .password("pass")
                                .roles("ADMIN", "USER")
                                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }*/

}
