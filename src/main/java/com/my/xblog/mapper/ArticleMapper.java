package com.my.xblog.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.my.xblog.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.my.xblog.entity.Category;

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

    /**
     * 分页获取文章按时间排序
     * @param page
     * @return
     */
    public Page<Article> listArticleByPageByTime(Page<Article> page) ;

    /**
     * 根据id获取文章
     * @param id
     * @return
     */
    Article findArticleByID(Long id);

    /**
     * 根据用户id获取文章列表
     * @param uid
     * @return
     */
    List<Article> listArticleByUserId(Long uid);

    /*
     * 根据分类获取文章
     * @Author Administrator
     * @Date 20:34 2020/12/24
     * @Param cid
     * @Param current
     * @Param size
     * @return
     **/
    Page<Article> listArticleByCategoryIdPage(Long cid, Page<Article> page);

    /**
     * Article与Category中间表
     * @param aid
     * @param cid
     */
    void insertArticleCategory(Long aid, Long cid);
}
