package com.fish.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component //компонент спринга
@Entity //сущность базы данный
@Table(name = "users") //соответствует таблице users
public class User {

    @Id //поле id в таблице
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO) //генерируемое значение
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
