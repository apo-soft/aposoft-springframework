package io.github.dunwu.spring.core.resources;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 一个 JavaBean 示例
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;

    private String address;

    private String phone;

    private BeanFactory beanFactory;

    private String beanName;

    private Business business;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone=" + phone + ", business=" + business + "]";
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Person【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String beanName) {
        System.out.println("Person【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("Person【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void myDestory() {
        System.out.println("Person【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        System.out.println("Person【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Person【注入属性】注入属性name:" + name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("Person【注入属性】注入属性address");
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("Person【注入属性】注入属性phone");
        this.phone = phone;
    }

    public Business getBusiness() {
        return business;
    }

    @Autowired
    @Qualifier("business_biden")
    public void setBusiness(Business business) {
        System.out.println("Person【注入属性】注入属性Business:" + business);
        this.business = business;
    }


}
