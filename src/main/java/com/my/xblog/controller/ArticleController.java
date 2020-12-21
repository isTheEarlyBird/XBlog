package com.my.xblog.controller;


import com.my.xblog.comment.MyResult;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/x-article")
@Api(tags = "文章详情")
public class ArticleController {

    @GetMapping("/findListArticle")
    public MyResult findListArticle(){
        return MyResult.success();
    }
}

