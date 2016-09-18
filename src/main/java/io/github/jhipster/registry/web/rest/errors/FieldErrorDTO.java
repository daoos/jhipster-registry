package io.github.jhipster.registry.web.rest.errors;

import java.io.Serializable;

/**
 * 字段错误对象
 *
 */
public class FieldErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字段类型
     */
    private final String objectName;

    /**
     * 字段名
     */
    private final String field;

    /**
     * 错误信息
     */
    private final String message;

    public FieldErrorDTO(String dto, String field, String message) {
        this.objectName = dto;
        this.field = field;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

}
