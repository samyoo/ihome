package com.ihome.core.model;


import com.ihome.common.utils.StrUtil;
import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class Profile extends Model<Profile> {

    public static Profile DAO = new Profile();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**key*/
        String key = "key";
        /**值*/
        String value = "value";
        /**描述*/
        String description = "description";
    }

    public List<Profile> findALl(){
        return this.find("select * from t_profire");
    }

    public Page<Profile> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append(" from t_profile where 1=1 ");
        if(StrUtil.isNotBlank(vo.getVal())){
            sql.append(" and `value` like '%").append(vo.getVal()).append("%' ");
        }
        if(StrUtil.isNotBlank(vo.getName())){
            sql.append(" and `key` like '%").append(vo.getName()).append("%' ");
        }

        return this.paginate(vo.getPage(),vo.getSize(),"select * ",sql.toString());
    }
}
