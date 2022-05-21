package com.haifei.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * vo
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

}
