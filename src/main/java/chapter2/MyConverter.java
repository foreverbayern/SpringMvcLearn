package chapter2;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author:lucky date:2018/6/2
 * time:11:35
 * 自定义类型转换器，需要让spring来进行管理
 */
@Component
public class MyConverter implements Converter<String,User> {
    @Override
    public User convert(String s) {
        //将String字符串转换为User对象返回
        return null;
    }
}
