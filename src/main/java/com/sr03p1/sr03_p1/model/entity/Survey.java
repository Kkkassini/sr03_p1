package com.sr03p1.sr03_p1.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.lang.Boolean;

@Entity
@Table(name="SURVEY")
public class Survey {

    // attributs privés
    private Integer id;
    private String subject;
    private Boolean status;

    public Survey() {}

    // classe publique

    public Survey(Integer id, String subject, Boolean status) {
        this.id = id;
        this.subject = subject;
        this.status = status;
    }

    // fonction set

    public void setId(Integer id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // fonction get

    @Id
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    @Basic
    @NotNull
    @Column(name = "SUBJECT")
    public String getSubject() {
        return subject;
    }

    @Basic
    @NotNull
    @Column(name = "STATUS")
    public Boolean getStatus() {
        return status;
    }
}

