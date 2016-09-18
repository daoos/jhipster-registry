package io.github.jhipster.registry.web.rest.errors;

import java.io.Serializable;

/**
 * 发送一个参数化的错误消息
 * DTO for sending a parameterized error message.
 */
public class ParameterizedErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 错误信息
     */
    private final String message;
    /**
     * 参数
     */
    private final String[] params;

    public ParameterizedErrorDTO(String message, String... params) {
        this.message = message;
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public String[] getParams() {
        return params;
    }

}
