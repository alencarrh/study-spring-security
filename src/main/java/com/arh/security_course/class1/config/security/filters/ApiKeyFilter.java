package com.arh.security_course.class1.config.security.filters;

import com.arh.security_course.class1.config.security.authentication.ApiKeyAuthentication;
import com.arh.security_course.class1.config.security.managers.CustomAuthenticationManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

  private final String key;

  @Override
  protected void doFilterInternal(
      HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    CustomAuthenticationManager manager = new CustomAuthenticationManager(key);
    String headerKey = request.getHeader("x-key");

    if (headerKey == null || "null".equals(headerKey)) {
      filterChain.doFilter(request, response);
    }

    var auth = new ApiKeyAuthentication(headerKey);

    try {
      var a = manager.authenticate(auth);
      if (a.isAuthenticated()) {
        SecurityContextHolder.getContext().setAuthentication(a);
        filterChain.doFilter(request, response);
      } else {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      }
    } catch (AuthenticationException e) {
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
  }
}
