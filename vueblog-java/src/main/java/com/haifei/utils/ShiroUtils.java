package com.haifei.utils;

import com.haifei.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * shiro工具类
 */
public class ShiroUtils {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }

}
