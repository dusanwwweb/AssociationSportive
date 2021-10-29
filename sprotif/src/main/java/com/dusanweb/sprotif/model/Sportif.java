package com.dusanweb.sprotif.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Document(collection = "Sportifs")
public class Sportif {

    @Transient
    public static final String SEQUENCE_NAME = "sportif_sequence";

    @Id
    private String id;
    @Field(name = "IdSportif")
    private int idSportif;
    @Field(name = "Nom")
    private String nom;
    @Field(name = "Prenom")
    private String prenom;
    @Field(name = "Sexe")
    private String sexe;
    @Field(name = "Age")
    private int age;
    @Field(name = "IdSportifConseiller")
    private int idSportifConseiller;
    @Field(name = "Sports")
    private Sport sports;
}