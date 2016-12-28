package com.ihome.core.controller.admin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.vo.ParamVo;
import com.ihome.core.model.House;
import com.ihome.core.model.Swot;
import com.ihome.core.model.User;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

/**
 * HouseController
 */
@Before(AdminInterceptor.class)
public class SwotController extends Controller {

    /**
     * 故障修修列表
     */
    public void list(){
        if(Constants.HTTP_GET.equals(getRequest().getMethod())){
            render(Constants.PAGE_LIST);
        }else{
            int page = getParaToInt("page", Constants.DEFAULT_PAGE);
            int size = getParaToInt("pageSize",Constants.DEFAULT_SIZE);

            String startTime = getPara("startTime");
            String endTime = getPara("endTime");
            int rId = getParaToInt("rId",-1);
            ParamVo vo = new ParamVo(page,size);
            //vo.setTel(tel);
            //vo.setName(name);
            vo.setEndTime(endTime);
            vo.setStartTime(startTime);
            vo.setrId(rId);
            Page<Swot> list = Swot.DAO.getPage(vo);

            renderJson(JsonUtil.getData(list));
        }

    }

    /**
     * 管理员保存
     */
    public void save(){
        House house = getModel(House.class);
        if(house.save()){
            renderJson(JsonUtil.getAddSucc());
        }else {
            renderJson(JsonUtil.getAddFail());
        }
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



}





