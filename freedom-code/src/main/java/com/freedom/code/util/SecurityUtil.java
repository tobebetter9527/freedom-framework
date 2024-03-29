package com.freedom.code.util;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


/**
 * 模拟security登录工具
 *
 * @author tobebetter9527
 * @create 2021/08/21 0:18
 */
@Component
public class SecurityUtil {

  @Autowired
  private UserDetailsService userDetailsService;

  public void logInAs(String username) {

    UserDetails user = userDetailsService.loadUserByUsername(username);
    if (user == null) {
      throw new IllegalStateException("User " + username + " doesn't exist, please provide a valid user");
    }

    SecurityContextHolder.setContext(new SecurityContextImpl(new Authentication() {
      @Override
      public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
      }

      @Override
      public Object getCredentials() {
        return user.getPassword();
      }

      @Override
      public Object getDetails() {
        return user;
      }

      @Override
      public Object getPrincipal() {
        return user;
      }

      @Override
      public boolean isAuthenticated() {
        return true;
      }

      @Override
      public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

      }

      @Override
      public String getName() {
        return user.getUsername();
      }
    }));
    org.activiti.engine.impl.identity.Authentication.setAuthenticatedUserId(username);
  }
}
