package com.my.xblog.mapper;

import com.my.xblog.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
public interface CommentMapper extends BaseMapper<Comment> {

    /*
     * 获取文章所有评论
     * @Author Administrator
     * @Date 21:08 2020/12/31
     * @Param articleId  文章id
     * @return
     **/
    List<Comment> listByArticleIdAsc(Long articleId);

    /*
     * 增加评论数
     * @Author Administrator
     * @Date 21:35 2021/1/3
     * @Param aid
     * @return
     **/
    void increaseComments(Long aid);
}
