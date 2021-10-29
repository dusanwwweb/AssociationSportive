package com.dusanweb.sprotif.service;

import com.dusanweb.sprotif.model.Sportif;
import com.dusanweb.sprotif.repository.SportifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SportifService {

    @Autowired
    SportifRepository sportifRepository;


    public List<Sportif> getAllSportifs(){
        return sportifRepository.findAll();
    }

    public void addSportif(Sportif sportif) {
        sportifRepository.insert(sportif);
    }

    public void updateSportif(Sportif sportif){
        Sportif savedSportif = sportifRepository.findById(sportif.getId())
                .orElseThrow(()-> new RuntimeException(
                   String.format("Cannot find sportif by ID %s", sportif.getId())));

        savedSportif.setIdSportif(sportif.getIdSportif());
        savedSportif.setNom(sportif.getNom());
        savedSportif.setPrenom(sportif.getPrenom());
        savedSportif.setSexe(sportif.getSexe());
        savedSportif.setAge(sportif.getAge());
        savedSportif.setIdSportifConseiller(sportif.getIdSportifConseiller());

        sportifRepository.save(sportif);

    }

    public Sportif getSportifByObjectId(String id){
        Optional<Sportif> sportif = sportifRepository.findById(id);
        return sportif.orElseThrow(()-> new RuntimeException(
                String.format("Cannot find sportif by ID %s", id)));
    }

    public void deleteSportif(String id){
        sportifRepository.deleteById(id);
    }

}
