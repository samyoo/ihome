package com.ihome.core.controller.weixin;

import com.jfinal.config.JFinalConfig;
import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.jfinal.MsgControllerAdapter;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.out.OutCustomMsg;
import com.jfinal.weixin.sdk.msg.out.OutNewsMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;
import com.jfinal.weixin.sdk.msg.out.TransInfo;

/**
 * Created by sam on 16-12-21.
 */
public class WeixinController extends MsgControllerAdapter {


    @Override
    protected void processInFollowEvent(InFollowEvent inFollowEvent) {

    }

    @Override
    public ApiConfig getApiConfig() {
        ApiConfig ac = new ApiConfig();
        ac.setAppId("wx39ba1b7d8dce5a96");
        ac.setAppSecret("2218918a7b8be8468399d79c9502ab5c");
        ac.setToken("123456");

        return ac;
    }

    @Override
    protected void processInTextMsg(InTextMsg inTextMsg) {
        System.out.println(inTextMsg.getContent());

        OutTextMsg onm = new OutTextMsg(inTextMsg);
        onm.setContent(inTextMsg.getContent());

        render(onm);
    }

    @Override
    protected void processInMenuEvent(InMenuEvent inMenuEvent) {

    }
}
