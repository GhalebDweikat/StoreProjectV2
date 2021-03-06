package Servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if ((request.getSession()!= null && request.getSession().getAttribute("user")!= null) || request.getRequestURI().equals("/login")){
            filterChain.doFilter(servletRequest,servletResponse);
        } else {
            //request.getRequestDispatcher("/login").forward(request,response);
            response.sendRedirect("login");
        }


    }

    @Override
    public void destroy() {

    }
}
