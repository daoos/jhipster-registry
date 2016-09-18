package io.github.jhipster.registry.web.rest.errors;

/**
 * 错误常量
 *
 */
public final class ErrorConstants {

    /**
     * 并发性故障错误
     */
    public static final String ERR_CONCURRENCY_FAILURE = "error.concurrencyFailure";
    /**
     * 拒绝访问错误
     */
    public static final String ERR_ACCESS_DENIED = "error.accessDenied";
    /**
     * 验证错误
     */
    public static final String ERR_VALIDATION = "error.validation";
    /**
     * 方法不支持
     */
    public static final String ERR_METHOD_NOT_SUPPORTED = "error.methodNotSupported";
    /**
     * 内部服务器错误
     */
    public static final String ERR_INTERNAL_SERVER_ERROR = "error.internalServerError";

    private ErrorConstants() {
    }

}
