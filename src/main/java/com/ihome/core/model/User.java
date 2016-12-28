package com.ihome.core.model;


import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class User extends Model<User> {

    public static User DAO = new User();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**组织ID*/
        String tel = "tel";
        /**用户名*/
        String name = "name";
    }

    public List<User> findAll(){
        return this.find("select * from t_user");
    }

    public Page<User> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append("from t_user  where 1=1 ");
        if(vo.gethId()!=null&&vo.gethId()>0){
            sql.append(" and `hId` = ").append(vo.getVal());
        }
        if(vo.getuId()!=null&&vo.getuId()>0){
            sql.append(" and `uId` = ").append(vo.getuId());
        }

        return this.paginate(vo.getPage(),vo.getSize(),"select * ",sql.toString());
    }
}
