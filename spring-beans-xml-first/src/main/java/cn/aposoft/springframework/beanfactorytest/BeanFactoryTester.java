package cn.aposoft.springframework.beanfactorytest;

import cn.aposoft.springframework.scan.Car;
import io.github.dunwu.spring.core.resources.Business;
import io.github.dunwu.spring.core.resources.Cake;
import io.github.dunwu.spring.core.resources.CakeFactory;
import io.github.dunwu.spring.core.resources.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.util.Properties;

public class BeanFactoryTester {


    public static void testFactory(BeanFactory factory) {
        testPropertyBean(factory);
        testProtoTypeBean(factory);
        testFactoryBean(factory);
        testNestedBeanFactory(factory);
        testGetComponentBean(factory);
    }

    private static void testGetComponentBean(BeanFactory factory) {
        try {
            Car car = factory.getBean(Car.class);
            System.out.println("car:" + car);
            car.setBrand("Benz");
            car.setModel("GLS 700");
            System.out.println(car);
        } catch (BeansException ex) {
            System.out.println("car is not found.");
            return;
        }
    }

    public static void testFactoryBean(BeanFactory factory) {
        CakeFactory cakeFactory = factory.getBean("&cake", CakeFactory.class);
        System.out.println("getBean ：CakeFactory :" + (cakeFactory != null));
        Cake cake = factory.getBean("cake", Cake.class);
        System.out.println(cake);
    }


    public static void testPropertyBean(BeanFactory factory) {
        Properties propertiesSetting = factory.getBean("propertiesSetting", Properties.class);
        System.out.println(propertiesSetting);
        @SuppressWarnings("deprecation")
        PropertySourcesPlaceholderConfigurer holder = factory.getBean("propertiesPlaceHolder", PropertySourcesPlaceholderConfigurer.class);
        System.out.println(holder);

    }

    public static void testProtoTypeBean(BeanFactory factory) {
        //  simple bean
//      City city = (City) factory.getBean("city");

        Cake cake = factory.getBean("cakeProtoType", Cake.class);
        System.out.println(cake + " is prototype bean");
    }

    public static void testDestroy(DefaultListableBeanFactory factory) {
        Object o = factory.getBean("person_zhangsan");
        factory.destroyBean(factory.getBean("business_biden"));
        factory.destroyBean(factory.getBean("person_zhangsan"));

        // destroyBean 仅调用bean的destroy方法，不会直接删除beanName和实际的对象引用
        Object o1 = factory.getBean("person_zhangsan");
        System.out.println("o==o1?" + (o == o1));

        // remove 方法也会调用 destroyBean 方法
        factory.removeBeanDefinition("person_zhangsan");
        // org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'person_zhangsan' available
        // 删除bean definition后，bean不再存在
        //        Object o2 = factory.getBean("person_zhangsan");
        //        System.out.println("O==02?" + (o == o2));
    }

    public static void testNestedBeanFactory(BeanFactory factory) {
        // load lisi first
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

    }
}
