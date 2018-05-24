package com.csdn.java8;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String name;
    private String sex;
    private Integer age;

    public Employee(String name, String sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Employee(String name) {
        this.name=name;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Employee other) {
        //如果返回为正数，按顺序插入；若为0，不插入；若为负数，倒序插入
        //return 0;
        //只比较年龄
        //return this.getAge().compareTo(other.getAge());
        //比较年龄，如果年龄相同，比较姓名(如果年龄和姓名相同，就代表同一个元素，就不存储)
        int num = this.getAge()-other.getAge();
        int result = num == 0? this.name.compareTo(other.name): num;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(sex, employee.sex) &&
                Objects.equals(age, employee.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age);
    }
}
