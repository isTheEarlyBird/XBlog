package com.my.xblog.util;

/**
 * @author Administrator
 * @ClassName RedisKeyUtils
 * @Description TODO
 * @date 2021/1/3 16:39
 * @Version 1.0
 **/
public class RedisKeyUtils {

    public static final String LIKES_KEY = "article_like";

    public static String likesField(Long uid, Long aid){
        return "likes"+"::"+uid+"::"+aid;
    }
}
