package com.ihome.core.controller;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.ihome.common.utils.JsonUtil;
import com.jfinal.core.Const;
import com.jfinal.core.Controller;
import com.jfinal.ext.plugin.config.ConfigKit;
import com.jfinal.upload.UploadFile;

import java.io.File;
import java.util.Map;

/**
 * Created by sam on 16-12-7.
 */
public class UploadController extends Controller {

    public void index(){
        UploadFile files = getFile("file");
        File f = files.getFile();
        System.out.println(f.getName());
        String upPath = files.getUploadPath() + File.separator + files.getFileName();
        System.out.println(upPath);

        String path = Joiner.on(File.separator)
                    .join(getRequest().getContextPath(),Const.DEFAULT_BASE_UPLOAD_PATH,files.getFileName());

        System.out.println(path);
        Map<String,String> map = Maps.newHashMap();
        map.put("src",path);
        renderJson(JsonUtil.getData(map));
    }
}
