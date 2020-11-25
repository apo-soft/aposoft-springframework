package cn.aposoft.springframework;

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

public class App {
    static Resource resource // = new FileSystemResource("D:\\src\\github\\pipi668\\aposoft-springframework\\spring-beans-xml-first\\src\\main\\resources\\spring-beans.xml");
            = new ClassPathResource("spring-beans.xml");
    public static void main(String[] args) {
        defaultListBeanFactory();
    }

    private static void testFactory(DefaultListableBeanFactory factory) {
        testPropertyBean(factory);
        testProtoTypeBean(factory);
        testFactoryBean(factory);
        testNestedBeanFactory(factory);
    }
    private static void testFactoryBean(DefaultListableBeanFactory factory) {
        CakeFactory cakeFactory = factory.getBean("&cake", CakeFactory.class);
        System.out.println("getBean ：CakeFactory :" + (cakeFactory != null));
        Cake cake = factory.getBean("cake", Cake.class);
        System.out.println(cake);
    }


    private static void testPropertyBean(DefaultListableBeanFactory factory){
        Properties propertiesSetting = factory.getBean("propertiesSetting",Properties.class);
        System.out.println(propertiesSetting);
        @SuppressWarnings("deprecation")
        PropertyPlaceholderConfigurer holder = factory.getBean("propertiesPlaceHolder",PropertyPlaceholderConfigurer.class);
        System.out.println(holder);

    }

    private static void testProtoTypeBean(DefaultListableBeanFactory factory){
        //  simple bean
//      City city = (City) factory.getBean("city");

        Cake cake = factory.getBean("cakeProtoType", Cake.class);
        System.out.println(cake + " is prototype bean");
    }

    private static void testNestedBeanFactory(DefaultListableBeanFactory factory) {
        factory.getBean("person_lisi");
        Business business = (Business) factory.getBean("business_biden_name2");
        Object o = factory.getBean("person_zhangsan");
        if (o instanceof Person) {
            Person p = (Person) o;
            System.out.println(p);
        }

        /*
            Spring 在没有嵌入式代码的前提下，不会生成代理类

           java.lang.Throwable
	            at io.github.dunwu.spring.core.resources.Business.toString(Business.java:25)
	            at java.lang.String.valueOf(String.java:2994)
         */
        System.out.println(business);
        System.out.println(business.getClass().getName());
        factory.destroyBean(factory.getBean("business_biden"));
        factory.destroyBean(factory.getBean("person_zhangsan"));


        // destroyBean 仅调用bean的destroy方法，不会直接删除beanName和实际的对象引用
        Object o1 = factory.getBean("person_zhangsan");
        System.out.println("O==01?" + (o == o1));
        // remove 方法也会调用 destroyBean 方法
        factory.removeBeanDefinition("person_zhangsan");

        // org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'person_zhangsan' available
        // 删除bean definition后，bean不再存在
        //        Object o2 = factory.getBean("person_zhangsan");
        //        System.out.println("O==02?" + (o == o2));
    }

    public static void defaultListBeanFactory() {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);
        System.out.println("\n完成BeanDefinition的加载.\n");
        testFactory(factory);
    }

    public static void legacyXmlBeanFactory() {
        System.out.println("Hello World!");
        XmlBeanFactory factory = new XmlBeanFactory(resource);
        testFactory(factory);
    }
}
