package com.arh.security_course.class1.config.security.filters;

import com.arh.security_course.class1.config.security.authentication.CustomAuthentication;
import com.arh.security_course.class1.config.security.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {

  private final CustomAuthenticationManager customAuthenticationManager;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    String key = String.valueOf(request.getHeader("x-key"));
    CustomAuthentication ca = new CustomAuthentication(false, key);

    var auth = customAuthenticationManager.authenticate(ca);

    if (auth.isAuthenticated()) {
      SecurityContextHolder.getContext().setAuthentication(auth);
      filterChain.doFilter(request, response); // only when authentication works
    }
  }
}
