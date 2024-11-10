package com.arh.security_course.class1.security.evaluator;

import org.springframework.security.core.context.SecurityContextHolder;

public class Hello2ConditionEvaluator {

  public boolean evaluate() {
    final var context = SecurityContextHolder.getContext().getAuthentication();
    return context.getAuthorities().stream().anyMatch(t -> t.getAuthority().equals("read"));
  }
}
