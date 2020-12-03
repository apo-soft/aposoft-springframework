package io.github.dunwu.spring.core.resources;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;

public class Business implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    public Business(Person legalRepresentative) {
        System.out.println("Business【构造器】调用Business的构造器实例化");
        this.legalRepresentative = legalRepresentative;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    private String corp = "Biden co. Ltd";

    public Person getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(Person legalRepresentative) {
        System.out.println("Business【注入属性】注入属性legalRepresentative");
        this.legalRepresentative = legalRepresentative;
    }


    private City city;

    private Person ;legalRepresentative

    public City getCity() {
        return city;
    }

    @Autowired
    public void setCity(City city) {
        System.out.println("Business【注入属性】注入属性city :" + city);
        this.city = city;
    }


    @Override
    public String toString() {
        //// 用于表示是否会生成代理类：结论不会
//        Throwable t = new Throwable();
//        t.printStackTrace(System.out);
        return this.corp;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("Business 【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Business 【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Business 【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Business 【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }
}
