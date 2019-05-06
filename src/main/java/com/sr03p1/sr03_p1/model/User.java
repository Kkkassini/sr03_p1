package com.sr03p1.sr03_p1.model;


public class User {

    // attributs privés

    private String mail;
    private String name;
    private String password;
    private String company;
    private String phone;
    private String creationDate;
    private int isAdmin;
    private int isActive;

    public User() {}

    // classe publique

    public User(String mail, String name, String password, String company, String phone, String creationDate, int isAdmin, int isActive) {
        this.mail = mail;
        this.name = name;
        this.password = password;
        this.company = company;
        this.phone = phone;
        this.creationDate = creationDate;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
    }

    // fonction set
    public void setMail(String mail) { this.mail = mail; }
    public void setName(String name) { this.name = name; }
    public void setPassword(String password) { this.password = password; }
    public void setCompany(String company) { this.company = company; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCreationDate(String creationDate) { this.creationDate = creationDate; }
    public void setIsAdmin(int isAdmin) { this.isAdmin = isAdmin; }
    public void setIsActive(int isActive) {this.isActive = isActive; }

    // fonction get
    public String getMail() { return mail; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public String getCompany() { return company; }
    public String getPhone() { return phone; }
    public String getCreationDate() { return creationDate; }
    public int getIsAdmin() { return isAdmin; }
    public int getIsActive() { return isActive; }

    // fonctions utilitaires
    public Boolean isActive() {
        if(isActive == 0) {return Boolean.FALSE;}
        else {return Boolean.TRUE;}
    }

    @Override
    public String toString() {
        return "User{" + "mail="+mail+", name="+name+", company="+company+", phone="+phone+", creationDate="+creationDate+", isAdmin="+isAdmin+", isActive="+isActive+"}";
    }
}

