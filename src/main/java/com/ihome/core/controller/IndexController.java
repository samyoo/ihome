package com.ihome.core.controller;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.UserInterceptor;
import com.ihome.core.model.Menu;
import com.ihome.core.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * IndexController
 */
@Before(UserInterceptor.class)
public class IndexController extends Controller {
	public void index() {

        render("index.html");
	}

	public void getNav(){
        List<Record> list = Menu.DAO.findMenu();
        List<Record> mm = list.stream()
                .filter(menu -> menu.getInt("pId")==0)
                .collect(Collectors.toList());

        Map<String,List<Record>> child = list.stream()
                .filter(r -> r.getInt("pId")!=0)
                .collect(Collectors.groupingBy(m->m.getInt("pId")+""));

        mm.stream().filter(r -> {
            List l = (List)child.get(r.getInt("id")+"");
            return l !=null && l.size()>0;
        }).forEach(r -> r.set("children",child.get(r.getInt("id")+"")));

        renderJson(mm);
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





