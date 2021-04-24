package com.flights.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sdixit
 * @since 21-04-2021
 */
public class PostFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(PostFilter.class);

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();

        logger.info("Post Filter: " + String.format("Response Status Code: %s", context.getResponse().getStatus()));

        return null;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public String filterType() {
        return "post";
    }

}
