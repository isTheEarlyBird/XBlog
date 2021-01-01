package com.my.xblog.service.impl;

import com.my.xblog.entity.Comment;
import com.my.xblog.entity.Reply;
import com.my.xblog.mapper.CommentMapper;
import com.my.xblog.mapper.ReplyMapper;
import com.my.xblog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReplyMapper replyMapper;

    @Override
    public List<Comment> postComment(Comment comment) {
        comment.setCreateTime(new Date());
        comment.setUpdateTime(new Date());
        baseMapper.insert(comment);
        //存入redis

        return this.listComment(comment.getArticleId());
    }

    /*
     * 获取评论和回复
     * @Author Administrator
     * @Date 21:25 2020/11/29
     * @Param articleId 文章id
     * @return
     **/
    public List<Comment> listComment(Long articleId) {

        //获取该文章所有评论
        List<Comment> commentsList = commentMapper.listByArticleIdAsc(articleId);

        //获取该文章所有回复
        List<Reply> list = replyMapper.listByArticleIdAsc(articleId);

        ArrayList<Long> indexList = new ArrayList<>(commentsList.size());
        //将评论id放入list中，方便查询
        for (Comment com : commentsList) {
            indexList.add(com.getId());
        }
        Comment comment;
        if (null != list) {
            for (int i = 0, length = list.size(); i < length; i++) {
                Reply item = list.get(i);
                int index = indexList.indexOf(item.getCommentId());
                comment = commentsList.get(index);
                ArrayList<Reply> children = comment.getChildren();
                System.out.println(item);
                children.add(item);
            }
        }
        // redis 添加
        return commentsList;
    }

    @Override
    public List<Comment> postReply(Reply reply) {
        reply.setCreateTime(new Date());
        reply.setUpdateTime(new Date());
        replyMapper.insert(reply);
        //存入redis

        return this.listComment(reply.getArticleId());
    }
}
