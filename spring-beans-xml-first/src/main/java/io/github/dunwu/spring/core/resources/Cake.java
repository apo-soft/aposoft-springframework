package io.github.dunwu.spring.core.resources;

public class Cake {
    public Cake(){
        System.out.println("Cake【构造器】调用Cake的构造器实例化");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Cake 设置属性name：" + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "cake:" + this.name;
    }
}
