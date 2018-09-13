package com.mobidic.datasource.models;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.TemporalType;
import org.hibernate.annotations.Type;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity
@Table(name = "client_entries")
public class Client_entry implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="entry_id")
    @JsonBackReference(value="entry_client_entries")
    private Entry entry;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonBackReference(value="client_client_entries")
    private Client client;

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

    protected Client_entry() {
    }

    public Client_entry(String placeholder) {
        
    }
}