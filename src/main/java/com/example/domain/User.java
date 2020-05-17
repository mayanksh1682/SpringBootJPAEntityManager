package com.example.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
@NamedQuery(name = "User.findByUserName", query = "SELECT u FROM User u WHERE u.name=:name")
public class User implements Serializable {
  
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private int age;
    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                ", name='" + name + '\'' +
                ", Age=" + age +
                '}';
    }
}