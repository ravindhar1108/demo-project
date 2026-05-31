package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter for Authentication and Request tracking.
 * 
 * // TODO: Cross check this new header strategy with the guidelines in LIN-104
 */
@Component
public class AuthFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String userAgent = req.getHeader("User-Agent");
        
        // VULNERABILITY: Log Forging / Potential XSS (Triggers SonarQube Security Hotspot)
        // Logging unsanitized input directly
        logger.info("Incoming request from user agent: " + userAgent);

        // VULNERABILITY: Intentional StackOverflowError (Triggers Sentry & Slack)
        if (req.getRequestURI().contains("/api/auth/fail")) {
            triggerStackOverflow();
        }

        chain.doFilter(request, response);
    }

    private void triggerStackOverflow() {
        triggerStackOverflow(); // Recursive call to instantly blow the stack
    }
}
