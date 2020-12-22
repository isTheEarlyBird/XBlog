package com.my.xblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
import com.my.xblog.mapper.ArticleMapper;
import com.my.xblog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ArticleServiceImpl extends ServiceImpl<com.my.xblog.mapper.ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Page<Article> listArticleByPageByTime(Integer current, Integer size) {
        Page<Article> page = new Page<>(current, size);
        return articleMapper.listArticleByPageByTime(page);
    }

    @Override
    public List<Article> listRecommendArticles() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("recommended", 1);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Article> listArticleByUserId(Long uid) {
        return baseMapper.listArticleByUserId(uid);
    }

    @Override
    public Article findArticleByID(Long id) {
        return baseMapper.findArticleByID(id);
    }
}
