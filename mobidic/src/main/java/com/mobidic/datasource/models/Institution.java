package com.mobidic.datasource.models;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "institutions")
public class Institution implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String name;

    // mappedBy the name of the parent field --> in class Client: private
    // Institution institution
    @Getter
    @Setter
    @OneToMany(mappedBy = "institution", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference(value = "institution_clients")
    private Set<Client> clients;

    @Getter
    @Setter
    @OneToMany(mappedBy = "institution", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference(value = "institution_supervisors")
    private Set<Supervisor> supervisors;

    @Getter
    @Setter
    @Column
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    @Getter
    @Setter
    @Column
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_at;

    protected Institution() {
    }

    public Institution(String name) {
        this.name = name;
        clients = new HashSet<Client>();
        supervisors = new HashSet<Supervisor>();
    }
}