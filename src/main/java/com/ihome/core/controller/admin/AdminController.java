package com.ihome.core.controller.admin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.vo.ParamVo;
import com.ihome.core.model.Admin;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * IndexController
 */
@Before(AdminInterceptor.class)
public class AdminController extends Controller {


    public void index() {

        render("user.html");
	}

    public void list(){

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





