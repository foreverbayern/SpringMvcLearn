package chapter1;

import lombok.Data;
import lombok.ToString;

/**
 * @author:lucky date:2018/6/1
 * time:11:50
 */
@Data
@ToString
public class User {
    private String username;
    private int age;
    private Address address;
}
