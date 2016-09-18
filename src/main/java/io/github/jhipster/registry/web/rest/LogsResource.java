package io.github.jhipster.registry.web.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import io.github.jhipster.registry.web.rest.dto.LoggerDTO;

/**
 * 在运行时控制器的视图和管理日志级别
 * Controller for view and managing Log Level at runtime.
 */
@RestController
@RequestMapping("/management/jhipster")
public class LogsResource {

    @RequestMapping(value = "/logs",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<LoggerDTO> getList() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        return context.getLoggerList()
            .stream()
            .map(LoggerDTO::new)
            .collect(Collectors.toList());
    }

    /**
     * 204没有内容
     * @param jsonLogger
     */
    @RequestMapping(value = "/logs",
        method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Timed
    public void changeLevel(@RequestBody LoggerDTO jsonLogger) {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.getLogger(jsonLogger.getName()).setLevel(Level.valueOf(jsonLogger.getLevel()));
    }
}
