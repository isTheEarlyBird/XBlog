package com.my.xblog.mapper;

import com.my.xblog.entity.Reply;
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
public interface ReplyMapper extends BaseMapper<Reply> {

    /*
     * 获取该文章所有回复
     * @Author Administrator
     * @Date 22:53 2020/12/31
     * @Param articleId 文章id
     * @return
     **/
    List<Reply> listByArticleIdAsc(Long articleId);
}
