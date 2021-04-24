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
public class PreFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(PreFilter.class);

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        // Logging request information
        logger.info("Pre Filter: " + String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

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
        return "pre";
    }
}
