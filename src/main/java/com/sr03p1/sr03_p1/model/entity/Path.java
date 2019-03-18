package com.sr03p1.sr03_p1.model.entity;
import javax.persistence.*;

import lombok.Data;

@Data
@Table(name="PATH")
@Entity
public class Path {

    @Id
    @Column(name = "PATH")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Basic
    @Column(name = "SCORE")
    private Integer score;

    @Basic
    @Column(name = "TIME")
    private Float time;

    @Basic
    @ManyToOne(cascade=CascadeType.ALL)
    private Integer pathId;




}
