package com.ihome.common;

import com.jfinal.handler.Handler;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionHandler extends Handler {

    @Override
    public void handle(String target, HttpServletRequest request,
                       HttpServletResponse response, boolean[] isHandled) {
        int index = target.toLowerCase().indexOf(";jsessionid");
        if (index != -1)
            target = target.substring(0, index);

        if (!(target.startsWith("/static") || isAjaxRequest(request))) {
            setMenu(request);
        }

        nextHandler.handle(target, request, response, isHandled);
    }

    public void setMenu(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String url = request.getRequestURI().replaceFirst(contextPath, "");
        Record record = Db.findFirst("select id,pId from t_menu where url=?",url);
        if(record != null){
            request.setAttribute("__id", record.getStr("id"));
            request.setAttribute("__pId", record.getStr("pId"));
        }
    }

    public boolean isAjaxRequest(HttpServletRequest request) {
        boolean isAjaxRequest = false;
        // 判断是否为ajax请求
        String requestType = request.getHeader("X-Requested-With");
        if ("XMLHttpRequest".equals(requestType)) {
            isAjaxRequest = true;
        }
        return isAjaxRequest;
    }
}
