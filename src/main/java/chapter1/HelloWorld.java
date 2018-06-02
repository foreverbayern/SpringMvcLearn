package chapter1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * requestMapping注解为控制器可以处理哪些请求
     * 在控制器类和方法上均可定义
     * 请求方式
     * params 定义请求参数
     * heads定义请求头
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index() {
        return "chapter1/index";
    }

    /**
     *使用pathvarible，映射url绑定的占位符
     * 这个功能向rest目标有很大意义
     *
     */
    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id") Integer id) {
        System.out.println(id);
        return "chapter1/show";
    }

    /**
     * 使用RequestParam绑定请求参数值
     *在处理方法上，RequestParam可以把请求参数传递给请求方法
     */
    @RequestMapping("/c1")
    public String c1(@RequestParam(value = "username",required = false) String username) {
        System.out.println(username);
        return "chapter1/user";
    }

    /**
     * RequesetHeader,请求头
     * 绑定请求报头的属性值
     * 请求头包含了若干个属性，服务器可以根据这个获取客户端的信息。
     */
    @RequestMapping("/c2")
    public String handle(@RequestHeader("Accept-Encoding") String encoding) {
        System.out.println(encoding);
        return "chapter1/success";
    }
    /**
     * CookieValue
     * 绑定请求中的cookie值
     */
    @RequestMapping("/c3")
    public String cookie(@CookieValue(value = "JSESSIONID",required = false)String sessionId){
        System.out.println(sessionId);
        return "chapter1/success";
    }

    /**
     * pojo作为参数
     * http://localhost:8081/chapter1/c4?username=123&age=1&address.addressname=666
     */
    @RequestMapping("/c4")
    public String pojo(User user) {
        System.out.println(user);
        return "chapter1/success";
    }

    /**
     * servlet原生api作为参数
     */
    @RequestMapping("/c5")
    public String c5(HttpServletRequest request){
        System.out.println(request);
        return "chapter1/success";
    }
}
