package com.sr03p1.sr03_p1.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "Answer")
@Entity
public class Answer {

    @Basic
    @Column(name = "STATUS")
    private Boolean status;

    @Basic
    @Column(name = "INDEX")
    private Integer index;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    private String entitled;


}
