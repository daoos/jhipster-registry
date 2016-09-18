package io.github.jhipster.registry.web.rest.dto;

import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;

/**
 * 对应一个用户机器权限
 * A DTO representing a user, with his authorities.
 */
public class UserDTO {

    @NotNull
    @Size(min = 1, max = 50)
    private String login;

    /**
     * 权限集合
     */
    private Set<String> authorities;

    public UserDTO() {
    }

    public UserDTO(String login, Set<String> authorities) {

        this.login = login;
        this.authorities = authorities;
    }

    public String getLogin() {
        return login;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
            "login='" + login + '\'' +
            ", authorities=" + authorities +
            "}";
    }
}
