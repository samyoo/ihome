package com.ihome.core.model;


import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class Swot extends Model<Swot> {

    public static Swot DAO = new Swot();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**房间ID*/
        String rId = "rId";
        /**读数类型:1电,2水*/
        String type = "type";
        /**记录年份*/
        String year = "year";
        /**记录月份*/
        String month = "month";
        /**录入时间*/
        String updateTime = "updateTime";
        /**读数值*/
        String val = "val";

    }

    public List<Swot> findAll(){
        return this.find("select * from t_swot");
    }

    public Page<Swot> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append(" from t_swot s left join t_room r on s.rId=r.id left join t_house h on r.hId=h.id where 1=1 ");
        if(vo.gethId()!=null&&vo.getrId()>0){
            sql.append(" and `rId` = ").append(vo.getrId());
        }

        return this.paginate(vo.getPage(),vo.getSize(),"select s.*,r.doorplate,h.name ",sql.toString());
    }
}
