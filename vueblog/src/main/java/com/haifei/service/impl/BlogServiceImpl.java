package com.haifei.service.impl;

import com.haifei.entity.Blog;
import com.haifei.mapper.BlogMapper;
import com.haifei.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yubaby
 * @since 2021-12-14
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
