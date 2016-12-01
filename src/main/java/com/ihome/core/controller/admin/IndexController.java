package com.ihome.core.controller.admin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.interceptor.UserInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.utils.MD5Util;
import com.ihome.common.utils.SessionUtil;
import com.ihome.core.model.Admin;
import com.ihome.core.model.Menu;
import com.ihome.core.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * IndexController
 */

public class IndexController extends Controller {

    @Before(AdminInterceptor.class)
    public void index() {

        render("index.html");
	}

    @Before(AdminInterceptor.class)
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

    @Before(AdminInterceptor.class)
	public void main() {

		render("main.html");
	}

	public void login(){
        render("login.html");
    }

    public void logout(){
        removeSessionAttr(Constants.LOGIN_ADMIN);
        render("login.html");
    }

    public void home(){
        String acc = getPara("acc");
        String pwd = getPara("pwd");

        Admin admin = Admin.DAO.findByAcc(acc);
        if(admin != null){
            String apwd = admin.getStr(Admin.ATTR.pwd);
            if(apwd.equals(MD5Util.getMD5Pwd(pwd))){
                setSessionAttr(Constants.LOGIN_ADMIN,admin);

                admin.set(Admin.ATTR.loginIp, SessionUtil.getIpAddr(getRequest()))
                        .set(Admin.ATTR.lastLoginIp,admin.getStr(Admin.ATTR.loginIp))
                        .set(Admin.ATTR.loginTime,new Date())
                        .set(Admin.ATTR.lastLoginTime,admin.getDate(Admin.ATTR.loginTime))
                        .update();

                renderJson(JsonUtil.getSucc("登录成功"));
            }else {
                renderJson(JsonUtil.getFail("登录失败"));
            }
        }else {
                renderJson(JsonUtil.getFail("登录失败"));
        }
    }
}





