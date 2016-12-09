package com.ihome.common.vo;

import java.io.Serializable;

/**
 * Created by sam on 16-12-1.
 */
public class ParamVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private int page ;
    private int size;
    private String name;
    private String tel;
    private String val;
    private String startTime;
    private String endTime;

    public ParamVo(int page, int size){
        this.page = page;
        this.size = size;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
