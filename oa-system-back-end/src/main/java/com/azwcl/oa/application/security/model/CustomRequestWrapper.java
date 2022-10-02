package com.azwcl.oa.application.security.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * 自定义请求
 *
 * @author az
 * @date 2022/10/02
 */

public class CustomRequestWrapper extends HttpServletRequestWrapper {

    private final Map<String, String> headers = new HashMap<>();


    public CustomRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public void addHeader(String key, String val) {
        headers.put(key, val);
    }

    @Override
    public String getHeader(String name) {
        return headers.get(name);
    }
}
