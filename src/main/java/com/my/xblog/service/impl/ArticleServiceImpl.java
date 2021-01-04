package com.my.xblog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
import com.my.xblog.entity.Category;
import com.my.xblog.mapper.ArticleMapper;
import com.my.xblog.service.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.my.xblog.service.CategoryService;
import com.my.xblog.util.RedisKeyUtils;
import com.my.xblog.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class ArticleServiceImpl extends ServiceImpl<com.my.xblog.mapper.ArticleMapper, Article> implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CategoryService categoryService;

    @Override
    public IPage<Article> listArticleByPageByTime(Integer current, Integer size) {
        IPage<Article> page = new Page<>(current, size);
        return articleMapper.listArticleByPageByTime(page);
    }

    @Override
    public List<Article> listRecommendArticles() {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.eq("recommended", 1);
        wrapper.eq("published", 1);
        return baseMapper.selectList(wrapper);
    }

    @Override
    public List<Article> listArticleByUserId(Long uid) {
        return baseMapper.listArticleByUserId(uid);
    }

    @Override
    public IPage<Article> listArticleByCategoryIdPage(Long cid, Integer current, Integer size) {
        IPage<Article> page = new Page<>(current, size);
        return articleMapper.listArticleByCategoryIdPage(cid, page);
    }

    @Override
    public Article findArticleById(Long id) {
        return articleMapper.findArticleById(id);
    }

    @Override
    @Transactional
    public Article watch(Long id) {
        articleMapper.increaseViews(id);
        return articleMapper.findArticleById(id);
    }

    @Override
    @Transactional
    public void insert(Article article) {
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        baseMapper.insert(article);
        for (Category category : article.getCategorys()) {
            Long cid = category.getId();
            if (null == cid){//自己创建的分类
                cid = categoryService.insert(category);//添加操作
            }
            //article与category中间表
            articleMapper.insertArticleCategory(article.getId(), cid);
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseLikes(Long aid) {

        articleMapper.increaseLikes(aid);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseLikes(Long aid) {

        articleMapper.decreaseLikes(aid);
    }
}
