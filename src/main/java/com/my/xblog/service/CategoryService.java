package com.my.xblog.service;

import com.my.xblog.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
public interface CategoryService extends IService<Category> {

    /**
     * @Description 获取所有分类
     * @author xuan
     * @date 2020/12/19 22:20
     * @Version 1.0
     **/
    public List<Category> listCategorys();


    /*
     * 获取前7个分类
     * @Author xuan
     * @Date 20:55 2020/12/23
     * @Param start
     * @Param end
     * @return java.util.List<com.my.xblog.entity.Category>
     **/
    public List<Category> listCategorys(Integer start, Integer end);
}
