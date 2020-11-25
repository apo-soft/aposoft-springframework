package io.github.dunwu.spring.core.resources;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class City  {

    public City(){
        System.out.println("City【构造器】调用City的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        //// 用于表示是否会生成代理类：结论不会
//        Throwable t = new Throwable();
//        t.printStackTrace(System.out);
        return this.name;
    }

}
