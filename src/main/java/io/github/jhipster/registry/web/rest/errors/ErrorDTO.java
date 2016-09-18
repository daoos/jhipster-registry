package io.github.jhipster.registry.web.rest.errors;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 传到错误对象
 * DTO for transfering error message with a list of field errors.
 */
public class ErrorDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 错误信息
     */
    private final String message;
    /**
     * 错误描述
     */
    private final String description;

    /**
     * 字段错误集合List
     */
    private List<FieldErrorDTO> fieldErrors;

    public ErrorDTO(String message) {
        this(message, null);
    }

    public ErrorDTO(String message, String description) {
        this.message = message;
        this.description = description;
    }

    public ErrorDTO(String message, String description, List<FieldErrorDTO> fieldErrors) {
        this.message = message;
        this.description = description;
        this.fieldErrors = fieldErrors;
    }

    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldErrorDTO(objectName, field, message));
    }

    public String getMessage() {
        return message;
    }

    public String getDescription() {
        return description;
    }

    public List<FieldErrorDTO> getFieldErrors() {
        return fieldErrors;
    }
}
