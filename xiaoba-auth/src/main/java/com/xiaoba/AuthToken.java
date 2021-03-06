package com.xiaoba;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 认证类
 * @author zhouning
 */
public class AuthToken implements AuthenticationToken {
    private String token;

    public AuthToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
