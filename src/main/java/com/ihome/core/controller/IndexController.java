package com.ihome.core.controller;

import com.ihome.common.constant.Constants;
import com.ihome.core.model.User;
import com.jfinal.core.Controller;

/**
 * IndexController
 */
public class IndexController extends Controller {
	public void index() {
		render("index.html");
	}
	public void user() {
		render("user.html");
	}

	public void login(){
        render("login.html");
    }

    public void home(){
        String acc = getPara("acc");
        String pwd = getPara("pwd");

        System.out.println(acc);
        System.out.println(pwd);

        User u = new User();
        setSessionAttr(Constants.LOGIN_ACCOUNT,u);

        renderJson("{\"msg\":\"ok\"}");
    }
}





