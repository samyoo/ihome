package com.ihome.core.controller.weixin;

import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.utils.MD5Util;
import com.ihome.common.utils.SessionUtil;
import com.ihome.core.model.Admin;
import com.ihome.core.model.Menu;
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


    public void index() {
        System.out.println("index");

        render(Constants.PAGE_INDEX);
	}

    public void detail() {
        System.out.println("detail");

        render(Constants.PAGE_DETAIL);
    }

}





