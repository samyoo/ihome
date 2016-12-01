package com.ihome.common.interceptor;

import com.ihome.common.constant.Constants;
import com.ihome.core.model.Admin;
import com.ihome.core.model.User;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

import javax.servlet.http.HttpServletRequest;

public class AdminInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation inv) {
        Controller controller = inv.getController();
        HttpServletRequest request = controller.getRequest();
        Admin user = (Admin) request.getSession().getAttribute(Constants.LOGIN_ADMIN);
        if(user != null) {
            inv.invoke();
        } else {
            controller.redirect("/admin/login");
        }
    }

}
