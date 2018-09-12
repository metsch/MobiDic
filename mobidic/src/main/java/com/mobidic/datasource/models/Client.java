package com.mobidic.datasource.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    @JoinColumn(name="institution_id")
    @JsonBackReference(value="institutions_clients")
    private Institution institution;

    protected Client() {
    }

    public Client(String firstname,String lastname,Date date_of_birth,Boolean is_female) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.date_of_birth=date_of_birth;
        this.is_female=is_female;
    }

    // Extra getter to display the institution_id in the json response
    public Long getInstitution_id(){
        return this.institution.getId();
    }
}