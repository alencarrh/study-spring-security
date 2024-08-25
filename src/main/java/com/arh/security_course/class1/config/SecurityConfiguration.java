package com.arh.security_course.class1.config;

import com.arh.security_course.class1.config.security.filters.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final CustomAuthenticationFilter customAuthenticationFilter;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.addFilterAt(customAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
        .build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return NoOpPasswordEncoder.getInstance();
    // return new BCryptPasswordEncoder();
  }
}
