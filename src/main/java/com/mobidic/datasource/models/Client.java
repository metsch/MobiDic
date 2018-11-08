package com.mobidic.datasource.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private Date date_of_birth;

    @Column
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean is_female;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    @JsonBackReference(value = "institution_clients")
    private Institution institution;

    @ManyToMany(mappedBy = "clients")
    private Set<Entry> entries;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    protected Client() {
    }

    public Client(String firstname, String lastname, Date date_of_birth, Boolean is_female, Institution institution) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.date_of_birth = date_of_birth;
        this.is_female = is_female;
        this.institution = institution;
    }
}