package com.ihome.core.controller.admin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.vo.ParamVo;
import com.ihome.core.model.Admin;
import com.ihome.core.model.Profile;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.oreilly.servlet.multipart.LimitedServletInputStream;

import java.util.Date;
import java.util.List;

/**
 * IndexController
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller {

    /**
     * 管理员列表
     */
    public void list(){

        if(Constants.HTTP_GET.equals(getRequest().getMethod())){
            render(Constants.PAGE_LIST);
        }else{
            int page = getParaToInt("page", Constants.DEFAULT_PAGE);
            int size = getParaToInt("pageSize",Constants.DEFAULT_SIZE);

            String tel = getPara("tel");
            String name = getPara("name");
            ParamVo vo = new ParamVo(page,size);
            vo.setTel(tel);
            vo.setName(name);

            Page<Admin> list = Admin.DAO.getPage(vo);

            renderJson(JsonUtil.getData(list));
        }

    }

    /**
     * 管理员保存
     */
    public void save(){
        Admin admin = getModel(Admin.class);
        admin.set(Admin.ATTR.regTime,new Date());
        if(admin.save()){
            renderJson(JsonUtil.getAddSucc());
        }else {
            renderJson(JsonUtil.getAddFail());
        }
    }

    /**
     * 管理员修改
     */
    public void update(){
        Admin admin = getModel(Admin.class);
        if(admin.update()){
            renderJson(JsonUtil.getEditSucc());
        }else {
            renderJson(JsonUtil.getEditFail());
        }
    }

    /**
     * 管理员修改状态
     */
    public void updateStatus(){
        int id = getParaToInt("id");
        int status = getParaToInt("status");
        if(Admin.DAO.updateStatus(id,status)){
            renderJson(JsonUtil.getEditSucc());
        }else{
            renderJson(JsonUtil.getEditFail());
        }
    }

    /**
     * 系统设置列表
     */
    public void profile(){
        if(Constants.HTTP_GET.equals(getRequest().getMethod())){
            render("profile.html");
        }else{
            int page = getParaToInt("page", Constants.DEFAULT_PAGE);
            int size = getParaToInt("pageSize",Constants.DEFAULT_SIZE);

            String val = getPara("val");
            String key = getPara("key");
            ParamVo vo = new ParamVo(page,size);
            vo.setVal(val);
            vo.setName(key);

            Page<Profile> list = Profile.DAO.getPage(vo);

            renderJson(JsonUtil.getData(list));
        }
    }

    /**
     * 配置保存
     */
    public void savePro(){
        Profile profile = getModel(Profile.class);
        if(profile.save()){
            renderJson(JsonUtil.getAddSucc());
        }else {
            renderJson(JsonUtil.getAddFail());
        }
    }

    /**
     * 配置修改
     */
    public void updatePro(){
        Profile profile = getModel(Profile.class);
        if(profile.update()){
            renderJson(JsonUtil.getEditSucc());
        }else {
            renderJson(JsonUtil.getEditFail());
        }
    }

}





