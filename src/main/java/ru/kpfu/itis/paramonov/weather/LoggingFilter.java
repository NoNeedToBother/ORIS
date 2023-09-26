package ru.kpfu.itis.paramonov.weather;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@WebFilter(filterName = "loggingFilter", urlPatterns = "/*")
public class LoggingFilter implements Filter {
    private ServletContext context;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        StringBuilder logMessage = new StringBuilder();

        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("username");

        logMessage.append("User: ").append(userName).append(", city: ").
                append(request.getParameter("city")).append(", request time: ").append(LocalDateTime.now());
        this.context.log(logMessage.toString());

        /*if (params != null) {
            String paramString = params.keySet().stream().map(
                            key -> key + "=" + Arrays.toString(params.get(key)))
                    .collect(Collectors.joining(",", "{", "}"));
            this.context.log(request.getRemoteAddr() + ": request params:" + paramString);
        }*/

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        this.context = filterConfig.getServletContext();
        this.context.log("LoggingFilter initialized");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}

