package chapter2;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author:lucky date:2018/6/1
 * time:17:44
 * 自定义视图
 */
@Component
public class MyView implements View {
    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.getWriter().print("hello view,time is "+new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
    }
}
