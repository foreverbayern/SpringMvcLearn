package chapter2;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Map;

/**
 * @author:lucky date:2018/6/1
 * time:12:43
 */
@Controller
@RequestMapping("/chapter2")
@SessionAttributes(value = {"user"})
public class View {
    /**
     * springmvc会把ModelAndView的model中数据放入到request域对象中
     *
     * @return
     */
    @RequestMapping("/c1")
    public ModelAndView c1() {
        ModelAndView view = new ModelAndView("chapter2/success");
        //添加模型数据到ModelAndView中
        view.addObject("time", new DateTime().toString("yyyy-MM-dd hh:mm:ss"));
        return view;
    }


    /**
     * Map和Model
     */
    @RequestMapping("/c2")
    public String c2(Map<String, Object> map) {
        map.put("names", Arrays.asList("tom", "tony", "mike"));
        return "chapter2/success";
    }

    /**
     * @SessionAttributes 谢昂多个请求之间共用某个模型属性数据，可以在控制器类上标注这个注解，
     * 将属性暂存与HttpSession。
     * 除了可以通过属性名指定需要放到会话中的属性外，还可以通过模型属性的对象类型指定
     * 哪些属性需要放在会话中
     */
    @RequestMapping("/c3")
    public String c3(Map<String, Object> map) {
        User user = new User();
        user.setName("nihao");
        user.setAge(30);
        map.put("user", user);
        return "/chapter2/success";
    }
    /**
     * ModelAttribute注解
     * 有这个注解的方法，会在每个目标方法执行之前被springmvc调用
     *
     * 执行流程
     * 1.执行这个注解修饰的方法，从数据库取对象，把对象放入Map中
     * 2.springmvc从Map中取出user对象，并把表单的请求参数，赋给该user对象的对应属性
     * 3.springmvc
     */


    /**
     * 自定义视图解析器
     */
    @RequestMapping("/c5")
    public String testView() {
        System.out.println("myview");
        return "myView";
    }

    /**
     * springmvc处理静态资源
     * 解决方法：
     * 在springmvc配置文件中配置<mvc:default-servlet-handler
     */
}
