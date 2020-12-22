package com.my.xblog.service.impl;

import com.my.xblog.entity.Category;
import com.my.xblog.mapper.CategoryMapper;
import com.my.xblog.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

    @Override
    public List<Category> listCategorys() {
        return baseMapper.selectList(null);
    }
}
