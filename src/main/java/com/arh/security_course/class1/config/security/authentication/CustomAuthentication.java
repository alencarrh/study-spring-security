package com.arh.security_course.class1.config.security.authentication;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class CustomAuthentication implements Authentication {

  private final boolean authenticated;
  private final String key;

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

  }



  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of();
  }

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getDetails() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return null;
  }

  @Override
  public String getName() {
    return "";
  }
}
