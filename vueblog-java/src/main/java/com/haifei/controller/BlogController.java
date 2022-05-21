package com.haifei.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haifei.commen.lang.Result;
import com.haifei.entity.Blog;
import com.haifei.service.BlogService;
import com.haifei.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yubaby
 * @since 2021-12-14
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    public Result list(@RequestParam(defaultValue = "1") Integer currentPage){
        Page page = new Page(currentPage, 5); //Page是MP自带的分页类
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("created"));
        // 当前仅按创建时间倒序排列，后续有其他需求可再改
        return Result.success(pageData);
    }

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable(name = "id") Long id){
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客不见了"); //可能被删除了
        return Result.success(blog);
    }

    //postman测试接口时记得开启redis

    @RequiresAuthentication //需要登录认证才能编辑
    @PostMapping("/edit")
    public Result edit(@Validated @RequestBody Blog blog){
        Blog tempBlog = null;
        if (blog.getId() != null){  //有博客id ==> 修改
            tempBlog = blogService.getById(blog.getId());
            // 只能编辑自己的文章(判断当前登录用户是否为文章作者)
            Assert.isTrue(tempBlog.getUserId().longValue() == ShiroUtils.getProfile().getId().longValue(), "没有权限编辑");
        }else { //无博客id ==> 添加
            tempBlog = new Blog();
            tempBlog.setUserId(ShiroUtils.getProfile().getId());
            tempBlog.setCreated(LocalDateTime.now());
            tempBlog.setStatus(0);

        }

        BeanUtils.copyProperties(blog, tempBlog, "id", "userId", "status", "created"); //设置忽略这四个字段（不用复制）
        boolean update = blogService.saveOrUpdate(tempBlog);
        return Result.success(null);
    }

}
