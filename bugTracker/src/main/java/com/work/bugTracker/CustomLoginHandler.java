package com.work.bugTracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class CustomLoginHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        String url = getTargetURL(authentication);
        if(response.isCommitted())
        {
            return;
        }
        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, url);
    }

    public String getTargetURL(Authentication auth)
    {
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        ArrayList<String> roles = new ArrayList<>();
        for(GrantedAuthority a : authorities)
            roles.add(a.getAuthority());
        if(roles.contains("admin") || roles.contains("ROLE_admin"))
            return "/admin";
        else
            return "/tester";
    }
}
