package com.tgzhao.filter;


import com.tgzhao.freemarker.FreemarkerHelper;
import com.tgzhao.model.ViewMode;

import javax.servlet.*;
import java.io.IOException;
import java.util.Map;

/**
 * Created by tgzhao on 2016/5/7.
 */
public class DynamicFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            Map<String, Object> data = FreemarkerHelper.buildCommonDataMap("", ViewMode.DYNAMIC);
            servletResponse.setCharacterEncoding("UTF-8");
            FreemarkerHelper.generateByTemplatePath("/blog/index.ftl", servletResponse.getWriter(), data);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void destroy() {

    }
}
