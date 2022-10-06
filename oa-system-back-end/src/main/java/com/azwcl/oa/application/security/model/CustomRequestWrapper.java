package com.azwcl.oa.application.security.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
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
        String val = super.getHeader(name);
        if (headers.containsKey(name)) {
            val = headers.get(name);
        }
        return val;
    }


    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> names= Collections.list(super.getHeaderNames());
        names.addAll(headers.keySet());

        return Collections.enumeration(names);
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> list= Collections.list(super.getHeaders(name));

        if (headers.containsKey(name)){
            list.add(headers.get(name));
        }

        return Collections.enumeration(list);
    }
}
