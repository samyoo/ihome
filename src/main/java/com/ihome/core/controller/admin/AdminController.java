package com.ihome.core.controller.admin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.vo.ParamVo;
import com.ihome.core.model.Admin;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import java.util.Date;

/**
 * IndexController
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller {

    /**
     * 列表
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
     * 保存
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
     * 修改
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
     * 修改状态
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

}





