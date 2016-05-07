package com.tgzhao.config;

import freemarker.template.Version;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;

/**
 * Created by tgzhao on 2016/5/7.
 */
public class Configuration {
    private static final Logger logger = Logger.getLogger(Configuration.class);
    private static final freemarker.template.Configuration configuration;
    private static ServletContext servletContext;

    static {
        configuration =  new freemarker.template.Configuration(new Version(2, 3, 22));
    }

    public static freemarker.template.Configuration getFreemarkerConfiguration() {
        return configuration;
    }

    public static void init(ServletContext servletContext) {
        Configuration.servletContext = servletContext;
        try {
            configuration.setDirectoryForTemplateLoading(new File(getContextPath()));
            configuration.setDefaultEncoding("UTF-8");
            if (logger.isInfoEnabled()) {
                logger.info("templateBasePath set success ... ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getContextPath() {
        return getContextPath("");
    }

    public static String getContextPath(String path) {
        String contextFile = servletContext.getRealPath(path);
        if (contextFile == null && !path.startsWith("/")) {
            contextFile = servletContext.getRealPath("/" + path);
        } else if (contextFile == null && path.startsWith("/")){
            contextFile = servletContext.getRealPath(path.substring(1));
        }
        if (logger.isInfoEnabled()) {
            logger.info("contextFile : " + contextFile);
        }
        return contextFile;
    }
}
