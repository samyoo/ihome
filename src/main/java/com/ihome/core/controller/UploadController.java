package com.ihome.core.controller;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.Maps;
import com.ihome.common.utils.DateUtil;
import com.ihome.common.utils.FileUtil;
import com.ihome.common.utils.JsonUtil;
import com.jfinal.core.Const;
import com.jfinal.core.Controller;
import com.jfinal.ext.plugin.config.ConfigKit;
import com.jfinal.upload.UploadFile;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by sam on 16-12-7.
 */
public class UploadController extends Controller {

    public void index(){
        UploadFile files = getFile("file");
        File f = files.getFile();
        String upPath = files.getUploadPath() + File.separator + files.getFileName();
        //System.out.println("upPath:"+upPath);
        String mvFile = FileUtil.getNewFileName(f.getName());
        //System.out.println("mvFile:"+mvFile);
        String path = Joiner.on(File.separator)
                .join(getRequest().getContextPath(),Const.DEFAULT_BASE_UPLOAD_PATH,mvFile);
       //System.out.println("path:"+path);
        try {
            FileUtils.moveFile(new File(upPath),new File(files.getUploadPath() + File.separator +mvFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        renderJson(JsonUtil.getData(ImmutableBiMap.of("src",path)));
    }

}
