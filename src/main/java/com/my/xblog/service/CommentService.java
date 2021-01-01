package com.my.xblog.service;

import com.my.xblog.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.my.xblog.entity.Reply;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
public interface CommentService extends IService<Comment> {
    /*
     * @Description 发布评论
     * @Author Administrator
     * @Date 22:11 2020/11/25
     * @Param comment
     * @return
     **/
    List<Comment> postComment(Comment comment);

    /*
     * 根据文章获取评论
     * @Author Administrator
     * @Date 9:38 2021/1/1
     * @Param articleId 文章id
     * @return
     **/
    List<Comment> listComment(Long articleId);

    /*
     * 回复
     * @Author Administrator
     * @Date 14:34 2021/1/1
     * @Param reply
     * @return
     **/
    List<Comment> postReply(Reply reply);
}
