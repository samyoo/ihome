package com.ihome.core.model;


import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class Menu extends Model<Menu> {

    public static Menu DAO = new Menu();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**组织ID*/
        String pId = "pId";
        /**用户名*/
        String title = "title";
        String icon = "icon";
        String href = "href";
        String spread = "spread";
        String children = "children";
    }

    public List<Menu> findALl(){
        return this.find("select * from t_user");
    }

    public List<Record> findMenu(){
        return Db.find("select * from t_menu where state=1 ");
    }
}
