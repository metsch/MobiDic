package com.mobidic.datasource.models;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private String flag;

    // TODO: Creation Timestamp gets currently deleted when the field is updated
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

    @Getter
    @Setter
    @ManyToMany(mappedBy = "categories")
    private Set<Entry> entries;

    protected Category() {
    }

    public Category(String name, String flag) {
        this.flag = name;
        this.flag = flag;
        created_at = new Date();
    }
}