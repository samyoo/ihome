package com.ihome.common.utils;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
public class FileUtil {

    public static String getFileExt(String fileName){
        return  fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getNewFileName(String name){
        return DateUtil.getDirDate()+"/"+System.currentTimeMillis() + FileUtil.getFileExt(name);
    }

    public static String formatPath(String path){
        path = path.substring(0,path.indexOf("WEB-INF"));
        return path;
    }

}
