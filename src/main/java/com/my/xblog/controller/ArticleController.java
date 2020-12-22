package com.my.xblog.controller;


import com.my.xblog.comment.MyResult;
import com.my.xblog.entity.Article;
import com.my.xblog.service.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/article")
@Api(tags = "文章详情")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/findListArticle")
    public MyResult findListArticle(){
        return MyResult.success();
    }

    /*
     * 根据id获取文章
     * @Author xuan
     * @Date 20:09 2020/12/22
     * @Param id
     * @return
     **/
    @GetMapping("/findArticleByID/{id}")
    public MyResult findArticleByID(@PathVariable Long id){
        List<Article> articles = articleService.listArticleByUserId(id);
        return MyResult.success().data("articles", articles);
    }
}

