 package com.example.CrudAppSecurBoor.config.handler;


import com.example.CrudAppSecurBoor.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository userRepository;

    public SuccessHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /*
    @Override
   public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/users");
        } else {
            httpServletResponse.sendRedirect("/admins");
        }
    }

    */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            httpServletResponse.sendRedirect("/admin");
            return;
        } else if (roles.contains("ROLE_USER")) {
            httpServletResponse.sendRedirect("/users");
            return;
        } else {
            httpServletResponse.sendRedirect("/");
            return;
        }
    }
}

