package com.my.xblog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
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
public interface ArticleMapper extends BaseMapper<Article> {

    public Page<Article> listArticleByPageByTime(Page<Article> page) ;
}
