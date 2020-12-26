package com.my.xblog.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuan
 * @Description 自定义返回值
 * @date 2020/12/19 14:19
 * @Version 1.0
 **/
@Data
public class MyResult {

    public static Integer SUCCESS = 20000;
    public static Integer ERROR = 20001;

    private boolean success;

    private Integer code;

    private String message;

    private Map<String, Object> data = new HashMap<>();

    private MyResult(){}

    public static MyResult success(){
        MyResult r = new MyResult();
        r.setSuccess(true);
        r.setCode(MyResult.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static MyResult error(){
        MyResult r = new MyResult();
        r.setSuccess(false);
        r.setCode(MyResult.ERROR);
        r.setMessage("失败");
        return r;
    }

    public MyResult success(Boolean b){
        this.setSuccess(b);
        return this;
    }

    public MyResult message(String message){
        this.setMessage(message);
        return this;
    }

    public MyResult code(Integer code){
        this.setCode(code);
        return this;
    }

    public MyResult data(String str, Object obj){
        this.data.put(str, obj);
        return this;
    }

    public MyResult data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
}