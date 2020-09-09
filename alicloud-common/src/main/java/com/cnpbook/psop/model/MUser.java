package com.cnpbook.psop.model;

import java.io.Serializable;

public class MUser implements Serializable {

    private static final long serialVersionUID =  -6257461220416124125L;

    private Integer id;

    private String username;

    private String loginName;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
}
