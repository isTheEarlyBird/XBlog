package com.my.xblog.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
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

    /**
     * 分页获取文章按时间排序
     * @param page
     * @return
     */
    public IPage<Article> listArticleByPageByTime(IPage<Article> page) ;


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
    IPage<Article> listArticleByCategoryIdPage(Long cid, IPage<Article> page);

    /**
     * Article与Category中间表
     * @param aid
     * @param cid
     */
    void insertArticleCategory(Long aid, Long cid);

    /*
     * 根据id获取文章
     * @Author Administrator
     * @Date 19:41 2020/12/31
     * @Param id
     * @return
     **/
    Article findArticleById(Long id);

    /*
     * 增加文章点赞数
     * @Author Administrator
     * @Date 20:24 2021/1/3
     * @Param aid
     * @return
     **/
    void increaseLikes(Long aid);

    /*
     * 减少文章点赞数
     * @Author Administrator
     * @Date 20:24 2021/1/3
     * @Param aid
     * @return
     **/
    void decreaseLikes(Long aid);

    /*
     * 增加文章观看数
     * @Author Administrator
     * @Date 20:24 2021/1/3
     * @Param aid
     * @return
     **/
    void increaseViews(Long id);
}
