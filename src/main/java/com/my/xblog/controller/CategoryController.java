package com.my.xblog.controller;


import com.my.xblog.common.MyResult;
import com.my.xblog.entity.Category;
import com.my.xblog.service.ArticleService;
import com.my.xblog.service.CategoryService;
import com.my.xblog.vo.CommonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author my
 * @since 2020-12-19
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ArticleService articleService;

    @GetMapping("/{cid}/{size}/{current}") //实现点击分类
    public MyResult categorys(@PathVariable String cid, @PathVariable Integer current, @PathVariable Integer size) {
        List<Category> allCategory = categoryService.listCategorys();

        CommonVO commonVO = new CommonVO();
        commonVO.setRecommendArticles(articleService.listRecommendArticles());
        commonVO.setCategorys(categoryService.listCategorys(1, 7));
        commonVO.setPageInfo(articleService.listArticleByCategoryIdPage(Long.valueOf(cid), current, size));

        return MyResult.success().data("allCategory", allCategory).data("commonVO", commonVO);
    }
}

