package com.mobidic.datasource.models;

import java.io.Serializable;
import java.sql.Date;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    // mappedBy the name of the parent field --> in class Client: private Institution institution
    @OneToMany(mappedBy = "institution", orphanRemoval = true,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference(value = "institutions_clients")
    private List<Client> clients;

    protected Institution() {
    }

    public Institution(String name) {
        this.name=name;
    }
}