package com.arh.security_course.class1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  @GetMapping("/hello")
  @PreAuthorize("hasAnyAuthority('read')")
  public String hello() {
    return "Hello";
  }

  @GetMapping("/hello1")
  public String hello1() {
    return "Hello";
  }

  @GetMapping("/hello2")
  public String hello2() {
    return "Hello";
  }

  @GetMapping("/hello3")
  public String hello3() {
    return "Hello";
  }
}
