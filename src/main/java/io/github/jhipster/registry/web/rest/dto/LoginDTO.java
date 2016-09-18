package io.github.jhipster.registry.web.rest.dto;

import javax.validation.constraints.*;

/**
 * 用户凭证对象
 * A DTO representing a user's credentials
 */
public class LoginDTO {

    /**
     * 用户名
     */
    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    /**
     * 用户密码
     */
    @NotNull
    @Size(min = 5, max = 64)
    private String password;

    /**
     * 是否记住我
     */
    private Boolean rememberMe;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean isRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
            "password='" + password + '\'' +
            ", username='" + username + '\'' +
            ", rememberMe=" + rememberMe +
            '}';
    }
}
