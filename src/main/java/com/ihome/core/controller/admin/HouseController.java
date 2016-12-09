package com.ihome.core.controller.admin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.vo.ParamVo;
import com.ihome.core.model.Admin;
import com.ihome.core.model.House;
import com.ihome.core.model.Profile;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

import java.util.Date;

/**
 * HouseController
 */
@Before(AdminInterceptor.class)
public class HouseController extends Controller {

    /**
     * 房屋列表
     */
    public void list(){
        String a = getRequest().getContextPath();
        System.out.println(a);

        if(Constants.HTTP_GET.equals(getRequest().getMethod())){
            render(Constants.PAGE_LIST);
        }else{
            int page = getParaToInt("page", Constants.DEFAULT_PAGE);
            int size = getParaToInt("pageSize",Constants.DEFAULT_SIZE);

            String tel = getPara("startTime");
            String name = getPara("endTime");
            ParamVo vo = new ParamVo(page,size);
            vo.setTel(tel);
            vo.setName(name);

            Page<House> list = House.DAO.getPage(vo);

            renderJson(JsonUtil.getData(list));
        }

    }

    /**
     * 管理员保存
     */
    public void save(){
        House house = getModel(House.class);
        /*if(house.save()){
            renderJson(JsonUtil.getAddSucc());
        }else {
            renderJson(JsonUtil.getAddFail());
        }*/
        renderJson(JsonUtil.getAddSucc());
    }

    /**
     * 管理员修改
     */
    public void update(){
        House house = getModel(House.class);
        if(house.update()){
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


}





