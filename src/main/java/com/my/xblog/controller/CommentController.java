package com.my.xblog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.my.xblog.common.MyResult;
import com.my.xblog.entity.Comment;
import com.my.xblog.entity.Reply;
import com.my.xblog.service.CommentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
@RequestMapping("/comment")
@Api(tags = "评论")
public class CommentController {

    @Autowired
    private CommentService commentService;



    /*
     * @Description 发布评论
     * @Author Administrator
     * @Date 22:11 2020/11/25
     * @Param comment
     * @return
     **/
    @PostMapping("/postComment")
    public MyResult postComment(@RequestBody Comment comment){

        List<Comment> commentList = commentService.postComment(comment);
        return MyResult.success().data("commentList", commentList);
    }

    /*
     * 发布回复
     * @Author Administrator
     * @Date 20:18 2020/12/3
     * @Param blogReply
     * @return com.myblog.blog.vo.MyResult
     **/
    @PostMapping("/postReply")
    public MyResult postReply(@RequestBody Reply reply) throws JsonProcessingException {

        System.out.println(reply);
        List<Comment> commentList = commentService.postReply(reply);
        return MyResult.success().data("commentList", commentList);
    }

    /*
     * 获取该文章的所有评论
     * @Author Administrator
     * @Date 17:20 2021/1/1
     * @Param articleId 文章id
     * @return
     **/
    @GetMapping("/listComment/{articleId}")
    public MyResult listComment(@PathVariable Long articleId){
        List<Comment> commentList = commentService.listComment(articleId);
        System.out.println(commentList);
        return MyResult.success().data("commentList", commentList);
    }
}

