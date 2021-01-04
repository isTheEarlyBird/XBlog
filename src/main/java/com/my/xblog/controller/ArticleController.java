package com.my.xblog.controller;


import com.my.xblog.common.MyResult;
import com.my.xblog.entity.Article;
import com.my.xblog.entity.Comment;
import com.my.xblog.service.ArticleService;
import com.my.xblog.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private CommentService commentService;

    /*
     * 根据用户id获取文章
     * @Author xuan
     * @Date 20:09 2020/12/22
     * @Param uid
     * @return
     **/
    @GetMapping("/listArticleByUserId/{uid}")
    public MyResult listArticleByUserId(@PathVariable Long uid){
        List<Article> articles = articleService.listArticleByUserId(uid);
        return MyResult.success().data("articles", articles);
    }

    /*
     *
     * @Author Administrator
     * @Date 19:13 2020/12/28
     * @Param article
     * @return
     **/
    @PostMapping("/insert")
    public MyResult insert(@RequestBody Article article){
        articleService.insert(article);
        return MyResult.success();
    }

    /*
     * 根据id获取文章
     * @Author xuan
     * @Date 20:09 2020/12/22
     * @Param uid
     * @return
     **/
    @GetMapping("/watch/{id}")
    public MyResult watch(@PathVariable Long id){
        Article article = articleService.watch(id);
        List<Comment> commentList = commentService.listComment(id);
        return MyResult.success().data("article", article).data("commentList", commentList);
    }

    /*
     * 增加文章点赞
     * @Author Administrator
     * @Date 21:28 2021/1/2
     * @Param aid
     * @return
     **/
    @ApiOperation("点赞文章")
    @PutMapping("/increaseLikes/{aid}")
    @CrossOrigin
    public MyResult increaseLikes(@PathVariable("aid") Long aid){

        articleService.increaseLikes(aid);
        return MyResult.success();
    }

    /*
     * 减少文章点赞
     * @Author Administrator
     * @Date 21:28 2021/1/2
     * @Param aid
     * @return
     **/
    @ApiOperation("点赞文章")
    @PutMapping("/decreaseLikes/{aid}")
    @CrossOrigin
    public MyResult decreaseLikes(@PathVariable("aid") Long aid){

        articleService.decreaseLikes(aid);
        return MyResult.success();
    }
}

