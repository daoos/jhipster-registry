package io.github.jhipster.registry.web.rest;

import io.github.jhipster.registry.config.JHipsterProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 配置文件信息接口
 *
 */
@RestController
@RequestMapping("/api")
public class ProfileInfoResource {

    @Inject
    Environment env;

    /**
     * jhipster配置信息
     */
    @Inject
    private JHipsterProperties jHipsterProperties;

    /**
     * 本地搜索位置
     */
    @Value("${spring.cloud.config.server.native.search-locations:}")
    private String nativeSearchLocation;

    /**
     * 
     */
    @Value("${spring.cloud.config.server.git.uri:}")
    private String gitUri;

    /**
     * 
     */
    @Value("${spring.cloud.config.server.git.search-paths:}")
    private String gitSearchLocation;

    @RequestMapping("/profile-info")
    public ProfileInfoResponse getActiveProfiles() {
        return new ProfileInfoResponse(env.getActiveProfiles(), getRibbonEnv(), nativeSearchLocation, gitUri, gitSearchLocation);
    }

    /**
     * 获取 Ribbon环境属性配置
     * @return
     */
    private String getRibbonEnv() {
        String[] activeProfiles = env.getActiveProfiles();
        String[] displayOnActiveProfiles = jHipsterProperties.getRibbon().getDisplayOnActiveProfiles();

        if (displayOnActiveProfiles == null) {
            return null;
        }

        List<String> ribbonProfiles = new ArrayList<>(Arrays.asList(displayOnActiveProfiles));
        List<String> springBootProfiles = Arrays.asList(activeProfiles);
        ribbonProfiles.retainAll(springBootProfiles);

        if (ribbonProfiles.size() > 0) {
            return ribbonProfiles.get(0);
        }
        return null;
    }

    /**
     * @author 
     * ProfileInfo 配置信息响应信息
     *
     */
    private class ProfileInfoResponse {
        public String[] activeProfiles;
        public String ribbonEnv;
        public String nativeSearchLocation;
        public String gitUri;
        public String gitSearchLocation;

        ProfileInfoResponse(String[] activeProfiles, String ribbonEnv, String nativeSearchLocation, String gitUri,
                            String gitSearchLocation) {
            this.activeProfiles = activeProfiles;
            this.ribbonEnv = ribbonEnv;
            this.nativeSearchLocation = nativeSearchLocation;
            this.gitUri = gitUri;
            this.gitSearchLocation = gitSearchLocation;
        }
    }
}
