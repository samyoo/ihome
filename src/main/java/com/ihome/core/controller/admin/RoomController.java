package com.ihome.core.controller.admin;

import com.google.common.collect.Lists;
import com.ihome.common.constant.Constants;
import com.ihome.common.interceptor.AdminInterceptor;
import com.ihome.common.utils.ExcelUtil;
import com.ihome.common.utils.FileUtil;
import com.ihome.common.utils.JsonUtil;
import com.ihome.common.vo.ParamVo;
import com.ihome.core.model.House;
import com.ihome.core.model.Room;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.LogInterceptor;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * RoomController
 */
@Before(AdminInterceptor.class)
public class RoomController extends Controller {

    /**
     * 房屋列表
     */
    public void list(){
        if(Constants.HTTP_GET.equals(getRequest().getMethod())){
            List<House> list = House.DAO.findALl();
            setAttr("hList",list);
            render(Constants.PAGE_LIST);
        }else{
            int page = getParaToInt("page", Constants.DEFAULT_PAGE);
            int size = getParaToInt("pageSize",Constants.DEFAULT_SIZE);

            String tel = getPara("startTime");
            String name = getPara("endTime");
            ParamVo vo = new ParamVo(page,size);
            vo.setTel(tel);
            vo.setName(name);

            Page<Room> list = Room.DAO.getPage(vo);

            renderJson(JsonUtil.getData(list));
        }

    }

    /**
     * 保存
     */
    public void save(){
        Room room = getModel(Room.class);
        if(room.save()){
            renderJson(JsonUtil.getAddSucc());
        }else {
            renderJson(JsonUtil.getAddFail());
        }
        renderJson(JsonUtil.getAddSucc());
    }

    /**
     * 管理员修改
     */
    public void update(){
        Room room = getModel(Room.class);
        if(room.update()){
            renderJson(JsonUtil.getEditSucc());
        }else {
            renderJson(JsonUtil.getEditFail());
        }
    }

    public void model(){
        String path = LogInterceptor.class.getClassLoader().getResource("").getPath();
        // 截取需要的路径
        path = FileUtil.formatPath(path);//E:/JavaTool/apache-tomcat-8.0.15/webapps/esr-sdap/
        String fileName="WEB-INF/classes/房间模板.xlsx";
        path=path+fileName;
        System.out.println(path);
        renderFile(new File(path));
    }

    /**
     * 上传房间数据
     */
    public void upload(){
        UploadFile files = getFile("file");
        try {
            String upPath = files.getUploadPath() + File.separator + files.getFileName();
            List<List<String[]>> list= ExcelUtil.readXlsx(upPath, "yyyyMMdd");
            List<Room> rList = Lists.newArrayList();

            list.get(0).stream().forEach(str->{
                Room room = new Room();
                room.set(Room.ATTR.floor,str[0]);
                room.set(Room.ATTR.doorplate,str[1]);
                room.set(Room.ATTR.roomType,str[2]);
                room.set(Room.ATTR.rentPrice,str[3]);
                room.set(Room.ATTR.elec,str[4]);
                room.set(Room.ATTR.water,str[5]);
                rList.add(room);
            });

            Db.batchSave(rList,20);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}





