package com.arh.security_course.class1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/hello1")
  @PreAuthorize("hasAnyAuthority('READ')")
  public Object hello1get() {
    final var contextHolder = SecurityContextHolder.getContext().getAuthentication();
    return contextHolder;
  }

  @PostMapping("/hello1")
  @PreAuthorize("hasAnyAuthority('WRITE')")
  public Object hello1post() {
    final var contextHolder = SecurityContextHolder.getContext().getAuthentication();
    return contextHolder;
  }

  @GetMapping("/hello2")
  public Object hello2() {
    return "Hello";
  }

  @PostMapping("/hello2")
  public Object hello3() {
    return "Hello";
  }
}
