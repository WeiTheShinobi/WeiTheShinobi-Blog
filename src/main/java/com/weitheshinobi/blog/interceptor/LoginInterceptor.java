package com.weitheshinobi.blog.interceptor;

import com.weitheshinobi.blog.constant.UserConstant;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.weitheshinobi.blog.constant.UserConstant.*;

public class LoginInterceptor implements HandlerInterceptor {

//    如果有登入就放行，沒登入就攔截。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute(USER) != null){
            return true;
        }
        response.sendRedirect("/admin");
        return false;
    }
}
