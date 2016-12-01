package com.ihome.common;

import com.ihome.common.plugin.SchedulerPlugin;
import com.ihome.core.controller.admin.AdminController;
import com.ihome.core.controller.admin.IndexController;
import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.ext.plugin.config.ConfigKit;
import com.jfinal.ext.plugin.config.ConfigPlugin;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.plugin.tablebind.ParamNameStyles;
import com.jfinal.plugin.activerecord.SqlReporter;
import com.jfinal.plugin.activerecord.tx.TxByMethods;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.plugin.redis.RedisPlugin;
import com.jfinal.render.FreeMarkerRender;

/**
 * Created by sam on 16-10-9.
 */
public class AppConfig extends JFinalConfig {

    private boolean ISDEV = true;

    /**
     * 配置常量
     */
    public void configConstant(Constants me) {
        new ConfigPlugin(".*.txt").reload(false).start();
        ISDEV = ConfigKit.getStr("devMode", "true").equals("true");
        me.setDevMode(ISDEV);

        me.setMaxPostSize(1024*1024*50);
        me.setBaseViewPath("/WEB-INF/views/");
        me.setError500View("/WEB-INF/views/error/500.html");
        me.setError404View("/WEB-INF/views/error/404.html");

        FreeMarkerRender.setProperty("template_update_delay", "0");// 模板更更新时间,0表示每次都加载
        FreeMarkerRender.setProperty("classic_compatible", "true");// 如果为null则转为空值,不需要再用!处理
        FreeMarkerRender.setProperty("whitespace_stripping", "true");// 去除首尾多余空格
        FreeMarkerRender.setProperty("date_format", "yyyy-MM-dd");
        FreeMarkerRender.setProperty("time_format", "HH:mm:ss");
        FreeMarkerRender.setProperty("datetime_format", "yyyy-MM-dd HH:mm:ss");
        FreeMarkerRender.setProperty("default_encoding", "UTF-8");

    }

    /**
     * 配置路由
     */
    public void configRoute(Routes me) {

        me.add("/admin", IndexController.class);
        me.add("/admin/admin", AdminController.class);

    }

    /**
     * 配置插件
     */
    public void configPlugin(Plugins me) {

        /** mysql配置**/
        DruidPlugin druidPlugin = new DruidPlugin(ConfigKit.getStr("jdbc.url"),
                ConfigKit.getStr("jdbc.username"),
                ConfigKit.getStr("jdbc.password"),
                ConfigKit.getStr("jdbc.driverClass"),
                ConfigKit.getStr("jdbc.filters"));
        me.add(druidPlugin);

        AutoTableBindPlugin arp = new AutoTableBindPlugin(druidPlugin,
                ParamNameStyles.lowerUnderlineModule("t"));
        arp.setShowSql(true);
        me.add(arp);



        // sql记录
        SqlReporter.setLog(true);

        /** redis配置 **/
        me.add(new RedisPlugin(ConfigKit.getStr("redis.name"),
                ConfigKit.getStr("redis.host")));

        /** job配置 **/
        me.add(new SchedulerPlugin("job.properties"));

    }


    /**
     * 配置全局拦截器
     */
    public void configInterceptor(Interceptors me) {
        // 在VIEW中可以使用SESSION
        me.add(new SessionInViewInterceptor());

        //me.add(new UserInterceptor());

        me.add(new TxByMethods("save","update","delete"));
    }

    /**
     * 配置处理器
     */
    public void configHandler(Handlers me) {
        //JSEESIONID处理
        me.add(new SessionHandler());
        // 添加druid连接池
        me.add(new DruidStatViewHandler("/druid"));
        // 添加页面contextpath
        me.add(new ContextPathHandler("contextPath"));
    }

}
