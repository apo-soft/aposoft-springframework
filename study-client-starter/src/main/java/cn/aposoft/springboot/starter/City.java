package cn.aposoft.springboot.starter;


import org.springframework.stereotype.Component;

@Component
public class City {
    private String name = "洛阳";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
