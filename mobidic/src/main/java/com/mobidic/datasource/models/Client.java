package com.mobidic.datasource.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String firstname;

    @Getter
    @Setter
    @Column
    private String lastname;

    @Getter
    @Setter
    @Column
    private Date date_of_birth;

    @Column
    @Setter
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean is_female;

    protected Client() {
    }

    public Client(String firstname) {

    }
}