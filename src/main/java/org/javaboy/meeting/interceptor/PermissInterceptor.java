package org.javaboy.meeting.interceptor;

import org.javaboy.meeting.model.Employee;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PermissInterceptor implements HandlerInterceptor {

    AntPathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if ("/".equals(requestURI) || "/doLogin".equals(requestURI) || "/register".equals(requestURI) || "/doReg".equals(requestURI) || "/errorPage".equals(requestURI)) {
            return true;
        }
        HttpSession session = request.getSession(true);
        Employee currentUser = (Employee) session.getAttribute("currentUser");
        if (pathMatcher.match("/admin/**", requestURI)) {
            if (currentUser != null && currentUser.getRole() == 2) {
                return true;
            }
        }else {
            if (currentUser != null) {
                return true;
            }
        }

        // 重定向到登陆页面
        response.sendRedirect("/errorPage");
        return false;
    }
}
