package cn.itcast.interceptor;

import cn.itcast.service.IpCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author zhuchifeng
 * @Date 2022/11/14 19:27
 * @Version 1.0
 */
public class IpCountInterceptor implements HandlerInterceptor {
    @Autowired
    private IpCountService ipCountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ipCountService.count();
        return true;
    }
}
