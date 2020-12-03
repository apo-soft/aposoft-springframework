package cn.aposoft.springframework.beans;

import cn.aposoft.springframework.beanfactorytest.BeanFactoryTester;
import io.github.dunwu.spring.core.resources.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.util.Properties;

/**
 *
 */

public class BeanFactoryApp {
    static Resource resource // = new FileSystemResource("D:\\src\\github\\pipi668\\aposoft-springframework\\spring-beans-xml-first\\src\\main\\resources\\spring-beans.xml");
            = new ClassPathResource("spring-beans.xml");
    public static void main(String[] args) {
        defaultListBeanFactory();
    }

    private static void testFactory(DefaultListableBeanFactory factory) {
        BeanFactoryTester.testFactory(factory);
        BeanFactoryTester.testDestroy(factory);
    }

    public static void legacyXmlBeanFactory() {
        System.out.println("Hello World!");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        testFactory(factory);
    }

    public static void defaultListBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println("\n完成BeanDefinition的加载.\n");
        testFactory(factory);
    }


}
