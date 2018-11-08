package com.mobidic.datasource.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.TemporalType;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "supervisors")
public class Supervisor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String password_digest;

    @ManyToOne
    @JoinColumn(name = "institution_id")
    @JsonBackReference(value = "institution_supervisors")
    private Institution institution;

    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    @OneToMany(mappedBy = "supervisor", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Entry> entries;

    protected Supervisor() {
    }

    public Supervisor(String firstname, String lastname, String password_digest) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.password_digest = password_digest;
    }

    // Extra getter to display the institution_id in the json response if required
    // public Long getInstitution_id() {
    // return this.institution.getId();
    // }
}