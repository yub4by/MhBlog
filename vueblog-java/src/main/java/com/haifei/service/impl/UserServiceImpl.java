package com.haifei.service.impl;

import com.haifei.entity.User;
import com.haifei.mapper.UserMapper;
import com.haifei.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
