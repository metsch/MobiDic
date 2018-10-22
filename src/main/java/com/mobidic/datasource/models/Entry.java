package com.mobidic.datasource.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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

@ToString
@Entity
@Table(name = "entries")
public class Entry implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String text;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    @JsonBackReference(value = "supervisors_entries")
    private Supervisor supervisor;

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

    // https://www.baeldung.com/hibernate-many-to-many
    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "clients_entries", joinColumns = { @JoinColumn(name = "entry_id") }, inverseJoinColumns = {
            @JoinColumn(name = "client_id") })
    private Set<Client> clients;

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "categories_entries", joinColumns = { @JoinColumn(name = "entry_id") }, inverseJoinColumns = {
            @JoinColumn(name = "category_id") })
    private Set<Client> categories;

    protected Entry() {
    }

    public Entry(String text) {
        this.text = text;
    }

    // Extra getter to display the institution_id in the json response
    public Long getSupervisor_id() {
        return this.supervisor.getId();
    }
}