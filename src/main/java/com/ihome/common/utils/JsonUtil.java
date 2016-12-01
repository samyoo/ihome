package com.ihome.common.utils;

import com.google.common.collect.Maps;
import com.jfinal.i18n.I18n;

import java.util.Map;

/**
 * Json工具
 */
public class JsonUtil {

    public interface STATE {
        /**
         * 成功状态-200
         */
        Short SUCC = 200;
        /**
         * 失败状态-500
         */
        Short FAIL = 500;

        /**
         * 状态-301
         */
        Short WARN_ONE = 301;
        /**
         * 状态-302
         */
        Short WARN_TWO = 302;
        /**
         * 状态-303
         */
        Short WARN_THR = 303;
        /**
         * 状态-304
         */
        Short WARN_FOU = 304;
        /**
         * 状态-501
         */
        Short ERROR_ONE = 501;
        /**
         * 状态-502
         */
        Short ERROR_TWO = 502;
        /**
         * 状态-503
         */
        Short ERROR_THR = 503;
        /**
         * 状态-601-未登录
         */
        Short OTHER_ONE = 601;
    }

    public interface MSG {

        /**
         * 操作出现异常，请稍后重试！
         */
        String PUBLIC_ERROR = "public.error";

    }

    /**
     * 获取资源值
     *
     * @return 资源值
     */
    public static String getMsg(String key) {
        return I18n.use().get(key);
    }

    /**
     * 获取返回信息
     *
     * @param msg 消息
     * @return Map
     */
    public static Map<String, Object> getSucc(String msg) {
        return getResult(STATE.SUCC, msg, null);
    }


    /**
     * 获取返回信息
     *
     * @param msg
     * @param data
     * @return
     */
    public static Map<String, Object> getSucc(String msg, Object data) {
        return getResult(STATE.SUCC, msg, data);
    }
    public static Map<String, Object> getData( Object data) {
        return getResult(STATE.SUCC, null, data);
    }



    /**
     * 获取返回信息
     *
     * @param msg
     * @return
     */
    public static Map<String, Object> getFail(String msg) {
        return getResult(STATE.FAIL, msg, null);
    }

    /**
     * 获取返回信息
     *
     * @param state 状态
     * @param msg   消息
     * @return Map
     */
    private static Map<String, Object> getResult(Short state, String msg, Object data) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("code", state);
        if (data != null) {
            map.put("data", data);
        }
        if(StrUtil.isNotBlank(msg)){
            map.put("msg", msg);
        }
        return map;
    }



    public static Map<String, Object> getAddSucc() {
        return getResult(STATE.SUCC, "添加成功", null);
    }
    public static Map<String, Object> getAddFail() {
        return getResult(STATE.FAIL, "添加失败", null);
    }
    public static Map<String, Object> getEditSucc() {
        return getResult(STATE.SUCC, "修改成功", null);
    }
    public static Map<String, Object> getEditFail() {
        return getResult(STATE.FAIL, "修改失败", null);
    }
    public static Map<String, Object> getDelSucc() {
        return getResult(STATE.SUCC, "删除成功", null);
    }
    public static Map<String, Object> getDelFail() {
        return getResult(STATE.FAIL, "删除失败", null);
    }

}
