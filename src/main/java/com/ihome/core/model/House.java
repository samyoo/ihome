package com.ihome.core.model;


import com.ihome.common.utils.StrUtil;
import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class House extends Model<House> {

    public static House DAO = new House();

    public interface ATTR{
        /**id*/
        String id = "id";
        /**名称*/
        String name = "name";
        /**地址*/
        String addr = "addr";
        /**区*/
        String area = "area";
        /**市*/
        String city = "city";
        /**省*/
        String province = "province";
        /**合同开始时间*/
        String startTime = "startTime";
        /**合同结束时间*/
        String endTime = "endTime";
        /**水价*/
        String waterPrice = "waterPrice";
        /**电价*/
        String elecPrice = "elecPrice";
        /**图片 */
        String imgs = "imgs";
        /**房东*/
        String own = "own";
        /**房东电话*/
        String tel = "tel";
        /**备注 */
        String remark = "remark";
    }

    public List<House> findALl(){
        return this.find("select * from t_house");
    }

    public Page<House> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append(" from t_house where 1=1 ");
        if(StrUtil.isNotBlank(vo.getVal())){
            sql.append(" and `value` like '%").append(vo.getVal()).append("%' ");
        }
        if(StrUtil.isNotBlank(vo.getName())){
            sql.append(" and `key` like '%").append(vo.getName()).append("%' ");
        }

        return this.paginate(vo.getPage(),vo.getSize(),"select * ",sql.toString());
    }
}
