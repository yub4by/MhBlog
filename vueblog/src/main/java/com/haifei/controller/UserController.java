package com.haifei.controller;


import com.haifei.commen.lang.Result;
import com.haifei.entity.User;
import com.haifei.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yubaby
 * @since 2021-12-14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试初始项目搭建(springboot,speingmvc,MP)是否ok
     * http://localhost:8081/user/index
     * @return
     */
//    @RequiresAuthentication //表示必须进行认证登录后才能访问的接口
    @GetMapping("/index")
    public Object index(){
//        return userService.getById(1L);

        User user = userService.getById(1L);
//        return Result.success(200, "操作成功", user);
        return Result.success(user);
    }

    /**
     * 测试后端实体校验
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(@Validated  @RequestBody User user){
        return Result.success(user);
    }

}
