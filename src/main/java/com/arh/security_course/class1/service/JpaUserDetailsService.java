package com.arh.security_course.class1.service;

import com.arh.security_course.class1.repository.UserRepository;
import com.arh.security_course.class1.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    var user = userRepository.findUserByUsername(username);

    return user.map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
  }
}
