package io.github.jhipster.registry.security;

/**
 * 安全常量
 * Constants for Spring Security authorities.
 */
public final class AuthoritiesConstants {

    /**
     * 管理员角色
     */
    public static final String ADMIN = "ROLE_ADMIN";

    /**
     * 普通用户角色
     */
    public static final String USER = "ROLE_USER";

    /**
     * 匿名用户角色
     */
    public static final String ANONYMOUS = "ROLE_ANONYMOUS";

    private AuthoritiesConstants() {
    }
}
