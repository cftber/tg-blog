package com.tgzhao.freemarker;

import com.tgzhao.config.Configuration;
import com.tgzhao.model.ViewMode;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateNotFoundException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * Created by tgzhao on 2016/5/7.
 */
public class FreemarkerHelper {
    private static final Logger logger = Logger.getLogger(FreemarkerHelper.class);

    public static Map<String, Object> buildCommonDataMap(String namespace, ViewMode viewMode) {
        Map<String, Object> data = new HashMap<>();
        data.put("contextPath", "http://localhost:8080");
        data.put("name", "tgzhao's blog demo 名字测试编码测试!~");
        System.out.println("名字测试编码测试");
        return data;
    }

    public static void generateByTemplatePath(String templatePath, Writer writer, Map<String, Object> data) {
        try {
            Template template = Configuration.getFreemarkerConfiguration().getTemplate(templatePath);
            template.process(data, writer);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
