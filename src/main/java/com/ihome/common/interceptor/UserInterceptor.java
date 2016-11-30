package com.ihome.common.interceptor;

import com.ihome.common.constant.Constants;
import com.ihome.core.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import javax.servlet.http.HttpServletRequest;

public class UserInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        HttpServletRequest request = controller.getRequest();
        User user = (User) request.getSession().getAttribute(Constants.LOGIN_ACCOUNT);

        if(user != null
                ||inv.getMethodName().equals("login")
                ||inv.getMethodName().equals("home")) {
            inv.invoke();
        } else {
          /*  String querystring = request.getQueryString();
            String beforeUrl = request.getRequestURL() + "?" + querystring;
            if(StrUtil.isBlank(querystring)) {
                beforeUrl = request.getRequestURL().toString();
            }*/
            controller.redirect("/login");
        }
    }

}
