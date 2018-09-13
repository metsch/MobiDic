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
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date timestamp;

    @Getter
    @Setter
    @Column
    private String text;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name="supervisor_id")
    @JsonBackReference(value="supervisors_entries")
    private Supervisor supervisor;

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

    protected Entry() {
    }

    public Entry(String text) {
        this.text=text;
    }

    // Extra getter to display the institution_id in the json response
    public Long getSupervisor_id(){
        return this.supervisor.getId();
    }
}