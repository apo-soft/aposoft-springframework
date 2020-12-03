package cn.aposoft.springframework.context;

import cn.aposoft.springframework.beanfactorytest.BeanFactoryTester;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class GenericApplicationContextApp {
    public static void main(String[] args) {
        System.out.println("\n------------------- APP BEGIN ----------------\n");
        GenericApplicationContext ctx = new GenericApplicationContext();
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(ctx);
        xmlReader.loadBeanDefinitions(new ClassPathResource("spring-beans.xml"));
        PropertiesBeanDefinitionReader propReader = new PropertiesBeanDefinitionReader(ctx);
        propReader.loadBeanDefinitions(new ClassPathResource("application.properties"));
        ApplicationContextTester.testApplicationContext(ctx);
    }


}
