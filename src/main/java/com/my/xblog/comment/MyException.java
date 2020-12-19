package com.my.xblog.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuan
 * @Description 自定义异常类
 * @date 2020/12/19 14:19
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyException extends RuntimeException
{

    private Integer code;//状态码
    private String message;//异常信息
}