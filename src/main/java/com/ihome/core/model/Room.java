package com.ihome.core.model;


import com.ihome.common.utils.StrUtil;
import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class Room extends Model<Room> {

    public static Room DAO = new Room();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**房源ID*/
        String hId = "hId";
        /**入住用户ID*/
        String uId = "uId";
        /**门牌*/
        String doorplate = "doorplate";
        /**楼层*/
        String floor = "floor";
        /**房型*/
        String roomType = "roomType";
        /**租金*/
        String rentPrice = "rentPrice";
        /**合同开始时间*/
        String startTime = "startTime";
        /**合同结束时间*/
        String endTime = "endTime";
        /**水读数*/
        String water = "water";
        /**电读数*/
        String elec = "elec";
        /**压金*/
        String deposit = "deposit";
        /**备注 */
        String remark = "remark";
    }

    public List<Room> findALl(){
        return this.find("select * from t_house");
    }

    public Page<Room> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append(" from t_room where 1=1 ");
        if(vo.gethId()!=null&&vo.gethId()>0){
            sql.append(" and `hId` = ").append(vo.getVal());
        }
        if(vo.getuId()!=null&&vo.getuId()>0){
            sql.append(" and `uId` = ").append(vo.getuId());
        }

        return this.paginate(vo.getPage(),vo.getSize(),"select * ",sql.toString());
    }
}
