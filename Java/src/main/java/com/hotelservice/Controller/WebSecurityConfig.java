/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotelservice.Controller;

import java.util.Arrays;
import static java.util.Arrays.asList;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.support.CronSequenceGenerator;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

/**
 *
 * @author somnathmali
 */
@Configurable
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .cors()
                .and()
                .csrf().disable();
               
                
}
    @Bean
   public CorsConfigurationSource configurationSource(){
       final CorsConfiguration configuration=new CorsConfiguration();
       configuration.setAllowedOrigins(asList("*"));
       configuration.setAllowedMethods(asList("GET","POST"));
       configuration.setAllowCredentials(true);
       configuration.setAllowedHeaders(asList("*"));
       final UrlBasedCorsConfigurationSource basedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
       basedCorsConfigurationSource.registerCorsConfiguration("*/**", configuration);
       return basedCorsConfigurationSource;
   }
    
}
