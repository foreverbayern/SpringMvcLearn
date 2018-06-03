package chapter3;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:lucky date:2018/6/2
 * time:17:10
 */
public class FirstInterceptor implements HandlerInterceptor {
    //业务处理器处理请求之前调用，在该方法中对用户请求request进行处理，如果还要调用其他拦截器，返回true，否则返回false
    //适合做权限
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle.........");
        return true;
    }

    //在业务处理器处理完请求后，在DispatcherServlet向客户端返回响应前被调用
    //调用目标方法之后，但在渲染视图之前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...........");
    }

    //在DispatcherServlet完全处理完请求后被调用
    //渲染视图之后，适合释放资源
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion.............");
    }
}
