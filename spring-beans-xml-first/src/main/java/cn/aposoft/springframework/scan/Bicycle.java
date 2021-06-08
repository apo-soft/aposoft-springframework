package cn.aposoft.springframework.scan;

public class Bicycle {

    public Bicycle() {
        System.out.println("bicycle is created");
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
