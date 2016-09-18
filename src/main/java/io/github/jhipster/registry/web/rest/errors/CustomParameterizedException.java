package io.github.jhipster.registry.web.rest.errors;

/**
 * 自定义,参数化的异常,可以在客户端翻译
 * Custom, parameterized exception, which can be translated on the client side.
 * For example:
 *
 * <pre>
 * throw new CustomParameterizedException(&quot;myCustomError&quot;, &quot;hello&quot;, &quot;world&quot;);
 * </pre>
 *
 * Can be translated with:
 *
 * <pre>
 * "error.myCustomError" :  "The server says {{params[0]}} to {{params[1]}}"
 * </pre>
 */
public class CustomParameterizedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 异常信息
     */
    private final String message;
    /**
     * 异常参数
     */
    private final String[] params;

    public CustomParameterizedException(String message, String... params) {
        super(message);
        this.message = message;
        this.params = params;
    }

    public ParameterizedErrorDTO getErrorDTO() {
        return new ParameterizedErrorDTO(message, params);
    }

}
