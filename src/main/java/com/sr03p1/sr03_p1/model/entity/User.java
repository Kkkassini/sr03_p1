package com.sr03p1.sr03_p1.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name="USER")
public class User {

    // attributs privés

    private String mail;
    private String name;
    private String password;
    private String company;
    private String phone;
    private String creationDate;
    private int status;
    private int isAdmin;

    public User() {}

    // classe publique

    public User(String mail, String name, String password, String company, String phone, String creationDate, int status, int isAdmin) {
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.company = company;
        this.phone = phone;
        this.creationDate = creationDate;
        this.status = status;
        this.isAdmin = isAdmin;
    }

    // fonction set

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    // fonction get

    @Id
    @Column(name = "MAIL")
    public String getMail() {
        return mail;
    }
    
    @Basic
    @NotNull
    @Column(name = "NAME")
    public String getName() {
        return name;
    }
    
    @Basic
    @NotNull
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Basic
    @NotNull
    @Column(name = "COMPANY")
    public String getCompany() {
        return company;
    }

    @Basic
    @NotNull
    @Column(name = "PHONE")
    public String getPhone() {
        return phone;
    }

    @Basic
    @NotNull
    @Column(name = "CREATION_DATE")
    public String getCreationDate() {
        return creationDate;
    }

    @Basic
    @NotNull
    @Column(name = "STATUS")
    public int getStatus() {
        return status;
    }

    @Basic
    @NotNull
    @Column(name = "IS_ADMIN")
    public int getIsAdmin() {
        return isAdmin;
    }

    // fonctions utilitaires

    public Boolean isActive() {
        if(status == 0) {return Boolean.FALSE;}
        else {return Boolean.TRUE;}
    }

    @Override
    public String toString() {
        return "User{" + "mail="+mail+", name="+name+", company="+company+", phone="+phone+", creationDate="+creationDate+", status="+status+"}";
    }
}

