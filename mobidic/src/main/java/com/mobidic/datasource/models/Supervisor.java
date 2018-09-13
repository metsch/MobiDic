package com.mobidic.datasource.models;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity
@Table(name = "supervisors")
public class Supervisor implements Serializable {

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
    private String password_digest;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="institution_id")
    @JsonBackReference(value="institutions_supervisors")
    private Institution institution;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date created_at;

    @Getter
    @Setter
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date updated_at;

    @Getter
    @Setter
    @OneToMany(mappedBy = "supervisor", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "supervisors_entries")
    private Set<Entry> entries;

    protected Supervisor() {
    }

    public Supervisor(String firstname,String lastname,String password_digest) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.password_digest=password_digest;
    }

    // Extra getter to display the institution_id in the json response
    public Long getInstitution_id(){
        return this.institution.getId();
    }
}