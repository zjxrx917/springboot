package com.csdn.reflect;

public class Person {
    private String name;
    private Integer age;
    private String sex;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    private Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public void show() {
        System.out.println("show");
    }

    public Person showMe(String name, Integer age) {
        Person p = new Person(name, age);
        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name  +
                ", age=" + age +
                ", sex=" + sex  +
                '}';
    }
}
