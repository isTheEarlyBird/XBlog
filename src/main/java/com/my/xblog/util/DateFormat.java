package com.my.xblog.util;

import io.swagger.annotations.ApiModel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuan
 * @ClassName DateFormat
 * @Description TODO
 * @date 2020/12/20 14:34
 * @Version 1.0
 **/
@ApiModel("日期格式化")
public class DateFormat {

    public static String format(Date date){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }
}
