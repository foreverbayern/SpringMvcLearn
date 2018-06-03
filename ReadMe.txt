需要进行spring整合springmvc吗？

    1.需要：通常情况下，类似于数据源，事务，整合其他框架，都是放在spring的配置文件里，而不是放在springmvc配置文件里，
    实际上放入spring配置文件对应的ioc容器的还有service和dao
    2.不需要：都放在springmvc配置文件中，这样不好

整合的时候，如果spring的ioc容器和springmvc的ioc容器有重合部分，会导致bean被创建2次，解决方法：
    1.强制规定没有重合扫描的包。
    2.使用exclude-filter


spirng的ioc容器和springmvc的ioc容器之间的关系
    springmvc的ioc容器的bean可以引用spring的ioc容器的bean，反过来就不行