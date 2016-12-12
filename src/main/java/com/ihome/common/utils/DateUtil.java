package com.ihome.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/12/10 0010.
 */
public class DateUtil {


    public static String getDirDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MMdd");
        return sdf.format(new Date());
    }
}
