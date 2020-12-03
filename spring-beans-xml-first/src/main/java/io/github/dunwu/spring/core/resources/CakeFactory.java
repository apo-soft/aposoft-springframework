package io.github.dunwu.spring.core.resources;

import org.springframework.beans.factory.FactoryBean;

public class CakeFactory implements FactoryBean<Cake> {

    public CakeFactory(){
        System.out.println("CakeFactory【构造器】调用CakeFactory的构造器实例化");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("CakeFactory 设置属性name：" + name);
        this.name = name;
    }


    @Override
    public Cake getObject() throws Exception {
        Cake cake = new Cake();
        cake.setName(this.name);
        return cake;
    }

    /**
     * Return the type of object that this FactoryBean creates,
     * or {@code null} if not known in advance.
     * <p>This allows one to check for specific types of beans without
     * instantiating objects, for example on autowiring.
     * <p>In the case of implementations that are creating a singleton object,
     * this method should try to avoid singleton creation as far as possible;
     * it should rather estimate the type in advance.
     * For prototypes, returning a meaningful type here is advisable too.
     * <p>This method can be called <i>before</i> this FactoryBean has
     * been fully initialized. It must not rely on state created during
     * initialization; of course, it can still use such state if available.
     * <p><b>NOTE:</b> Autowiring will simply ignore FactoryBeans that return
     * {@code null} here. Therefore it is highly recommended to implement
     * this method properly, using the current state of the FactoryBean.
     *
     * @return the type of object that this FactoryBean creates,
     * or {@code null} if not known at the time of the call
     * @see ListableBeanFactory#getBeansOfType
     */
    @Override
    public Class<Cake> getObjectType() {
        return Cake.class;
    }
}
