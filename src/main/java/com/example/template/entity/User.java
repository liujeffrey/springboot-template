package com.example.template.entity;

import io.swagger.annotations.ApiModelProperty;

public class User {
    @ApiModelProperty(hidden = true)
    private int id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    private String password;

    private String name;

    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
