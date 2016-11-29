package com.ihome.core.model;


import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class Admin extends Model<Admin> {

    public static Admin DAO = new Admin();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**组织ID*/
        String tel = "tel";
        /**用户名*/
        String name = "name";
    }

    public List<Admin> findALl(){
        return this.find("select * from t_admin");
    }

}
