package cn.aposoft.springframework.context;

import cn.aposoft.springframework.beanfactorytest.BeanFactoryTester;
import org.springframework.context.ConfigurableApplicationContext;

public class ApplicationContextTester {
    public static void testApplicationContext(ConfigurableApplicationContext context){
        System.out.println("\n------------------- Before refresh ----------------\n");
        context.refresh();
        System.out.println("\n------------------- Before getBean ----------------\n");
        BeanFactoryTester.testFactory(context);
        System.out.println("\n------------------- Before close context ----------------\n");
        context.close();
        System.out.println("\n------------------- after context closed ----------------\n");
    }
}
