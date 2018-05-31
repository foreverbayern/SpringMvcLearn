package capter1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:lucky date:2018/5/31
 * time:23:20
 */
@Controller
@RequestMapping("/chapter1")
public class HelloWorld {
    /**
     * requestmapping 映射请求
     * @return
     * 返回值会通过视图解析器解析为实际的物理视图，
     * 对于InternalResourceViewResolver视图解析器，会做如下解析
     * prefix+returnVal+suffix，得到实际的物理视图，然后做转发操作
     */
    @RequestMapping("/helloworld")
    public String hello() {
        System.out.println("hello world");
        return "success";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
