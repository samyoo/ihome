package com.ihome.core.model;


import com.ihome.common.utils.StrUtil;
import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/**
 * Created by sam on 16-11-29.
 */
public class Fault extends Model<Fault> {

    public static Fault DAO = new Fault();

 /*
 CREATE TABLE `t_fault` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rId` int(11) DEFAULT NULL COMMENT '房间ID',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `content` varchar(500) DEFAULT NULL COMMENT '故障内容',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `type` varchar(255) DEFAULT NULL COMMENT '故障类型',
  `aId` int(11) DEFAULT NULL COMMENT '管理员ID',
  `finishTime` datetime DEFAULT NULL COMMENT '完成时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
    */
    public interface ATTR{
        /**id*/
        String id = "id";
        /**房间ID*/
        String rId = "rId";
        /**创建时间*/
        String createTime = "createTime";
        /**故障内容*/
        String content = "content";
        /**备注*/
        String remark = "remark";
        /**状态*/
        String status = "status";
        /**标题*/
        String title = "title";
        /**故障类型*/
        String type = "type";
        /**管理员ID*/
        String aId = "aId";
        /**完成时间*/
        String finishTime = "finishTime";
    }

    public List<Fault> findAll(){
        return this.find("select * from t_fault");
    }

    public Page<Fault> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append(" from t_fault f left join t_room r on f.rId=r.id left join t_house h on r.hId=h.id  where 1=1 ");

        return this.paginate(vo.getPage(),vo.getSize(),"select f.*,r.doorplate,h.name ",sql.toString());
    }

}
