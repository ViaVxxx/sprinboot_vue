package com.via.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Table;


@Table(name = "user") //指定表名

public class User {

    @Id
    private Integer id;

    @Field(name = "name")
    private String name;

    @Field(name = "gender")
    private String gender;

    @Field(name = "age")
    private int age;

    @Field(name = "phone")
    private String phone;

    @Field(name = "password")
    private String password;


    // getter和setter方法，用来获取和设置属性值的
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String name, String gender, Integer age, String phone) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
    }
}
