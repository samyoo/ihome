package com.ihome.core.model;


import com.ihome.common.utils.StrUtil;
import com.ihome.common.vo.ParamVo;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

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
        String acc = "acc";

        String pwd = "pwd";
        String regTime = "regTime";
        String loginTime = "loginTime";
        String lastLoginTime = "lastLoginTime";
        String loginIp = "loginIp";
        String lastLoginIp = "lastLoginIp";
    }

    /**
     * 查询登录用户
     * @param acc
     * @return
     */
    public Admin findByAcc(String acc){
        return this.findFirst("select * from t_admin where acc = ? ",acc);
    }

    /**
     * 查询管理员列表
     * @param vo
     * @return
     */
    public Page<Admin> getPage(ParamVo vo){
        StringBuilder sql = new StringBuilder();
        sql.append("from t_admin where 1=1 ");
        if(StrUtil.isNotBlank(vo.getTel())){
            sql.append(" and tel = '").append(vo.getTel()).append("' ");
        }
        if(StrUtil.isNotBlank(vo.getName())){
            sql.append(" and name = '").append(vo.getName()).append("' ");
        }
        return this.paginate(vo.getPage(),vo.getSize(),"select * ",sql.toString());
    }
}
