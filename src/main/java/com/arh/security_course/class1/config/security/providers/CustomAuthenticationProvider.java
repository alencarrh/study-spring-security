package com.arh.security_course.class1.config.security.providers;

import com.arh.security_course.class1.config.security.authentication.CustomAuthentication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

  @Value("${our.very.very.secure.key}")
  private String key;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    final CustomAuthentication ca = (CustomAuthentication) authentication;

    final String headerKey = ca.getKey();

    if (key.equals(headerKey)) {
      return new CustomAuthentication(true, key);
    }

    throw new BadCredentialsException("Invalid key");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return CustomAuthentication.class.equals(authentication);
  }
}
