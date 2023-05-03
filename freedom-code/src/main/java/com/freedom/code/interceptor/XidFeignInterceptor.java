package com.freedom.code.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * TODO
 *
 * @author tobebetter9527
 * @create 2022/04/19 20:36
 */
//@Configuration
public class XidFeignInterceptor implements RequestInterceptor {

  @Override
  public void apply(RequestTemplate template) {
    RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
    if (requestAttributes != null) {
      String xid = (String) requestAttributes.getAttribute(RootContext.KEY_XID, 0);
      if (xid != null) {
        template.header(RootContext.KEY_XID, xid);
      }
    }
  }
}
