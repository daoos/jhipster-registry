package io.github.jhipster.registry.web.filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;

import io.github.jhipster.registry.config.JHipsterProperties;

/**
 * 这个过滤器是用于生产,将HTTP缓存头长(1个月)到期时间
 * This filter is used in production, to put HTTP cache headers with a long (1 month) expiration time.
 */
public class CachingHttpHeadersFilter implements Filter {

    // We consider the last modified date is the start up time of the server
//	我们考虑到最后修改日期是服务器的启动时间
    private final static long LAST_MODIFIED = System.currentTimeMillis();

    private long CACHE_TIME_TO_LIVE = TimeUnit.DAYS.toMillis(1461L);

    /**
     * jhipster配置属性
     */
    private JHipsterProperties jHipsterProperties;;

    /**
     * 缓存请求头过滤器构造器
     * @param jHipsterProperties
     */
    public CachingHttpHeadersFilter(JHipsterProperties jHipsterProperties) {
        this.jHipsterProperties = jHipsterProperties;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//    	获取配置的最大存活时长
        CACHE_TIME_TO_LIVE = TimeUnit.DAYS.toMillis(jHipsterProperties.getHttp().getCache().getTimeToLiveInDays());
    }

    @Override
    public void destroy() {
        // Nothing to destroy
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
        throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) response;
//添加请求头信息
        httpResponse.setHeader("Cache-Control", "max-age=" + CACHE_TIME_TO_LIVE + ", public");
        httpResponse.setHeader("Pragma", "cache");

        // Setting Expires header, for proxy caching
//        设置Expires标题,对代理缓存

        httpResponse.setDateHeader("Expires", CACHE_TIME_TO_LIVE + System.currentTimeMillis());

        // Setting the Last-Modified header, for browser caching
        httpResponse.setDateHeader("Last-Modified", LAST_MODIFIED);

        chain.doFilter(request, response);
    }
}
