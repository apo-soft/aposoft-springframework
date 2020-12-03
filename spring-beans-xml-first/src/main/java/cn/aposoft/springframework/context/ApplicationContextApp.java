package cn.aposoft.springframework.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

/**
 * 基于ApplicationContext的各种验证
 */
public class ApplicationContextApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(/* locations */ new String[]{"spring-beans.xml"}, false);
        ApplicationContextTester.testApplicationContext(context);
    }
}
