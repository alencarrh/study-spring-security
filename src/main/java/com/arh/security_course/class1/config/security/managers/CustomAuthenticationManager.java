package com.arh.security_course.class1.config.security.managers;

import com.arh.security_course.class1.config.security.providers.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

  private final CustomAuthenticationProvider provider;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    if (provider.supports(authentication.getClass())) {
      return provider.authenticate(authentication);
    }
    // returns null if more providers exists and should be executed as well
    throw new BadCredentialsException("Invalid key");
  }
}
