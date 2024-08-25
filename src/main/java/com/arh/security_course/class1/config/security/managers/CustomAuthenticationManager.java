package com.arh.security_course.class1.config.security.managers;

import com.arh.security_course.class1.config.security.providers.ApiKeyProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@RequiredArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

  private final String key;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    var provider = new ApiKeyProvider(key);
    if (provider.supports(authentication.getClass())) {
      return provider.authenticate(authentication);
    }
    return authentication;
  }
}
