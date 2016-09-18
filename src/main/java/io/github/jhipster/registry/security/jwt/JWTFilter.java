package io.github.jhipster.registry.security.jwt;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.ExpiredJwtException;

/**
 * token 过滤器
 * Filters incoming requests and installs a Spring Security principal if a header corresponding to a valid user is
 * found.
 */
public class JWTFilter extends GenericFilterBean {

    private final Logger log = LoggerFactory.getLogger(JWTFilter.class);

    /**
     * token 提供者
     */
    private TokenProvider tokenProvider;

    /**
     * 过滤器构造器
     * @param tokenProvider
     */
    public JWTFilter(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        try {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
//            分离出Token信息
            String jwt = resolveToken(httpServletRequest);
            if (StringUtils.hasText(jwt)) {
//            	jwt不为空
                if (this.tokenProvider.validateToken(jwt)) {
//                	根据token获取认证信息
                    Authentication authentication = this.tokenProvider.getAuthentication(jwt);
//                    设置对应的权限
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
//            程序继续处理
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (ExpiredJwtException eje) {
//        	jsonwebtoken 异常处理
            log.info("Security exception for user {} - {}", eje.getClaims().getSubject(), eje.getMessage());
//            设置返回状态为无权限401
            ((HttpServletResponse) servletResponse).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    /**
     * 分离出token信息
     * @param request
     * @return
     */
    private String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader(JWTConfigurer.AUTHORIZATION_HEADER);
        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            String jwt = bearerToken.substring(7, bearerToken.length());
            return jwt;
        }
        return null;
    }
}
