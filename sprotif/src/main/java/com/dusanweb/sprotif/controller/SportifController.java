package com.dusanweb.sprotif.controller;

import com.dusanweb.sprotif.model.Sportif;
import com.dusanweb.sprotif.service.SequenceGeneratorService;
import com.dusanweb.sprotif.service.SportifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/sportif")
public class SportifController {

    @Autowired
    SportifService sportifService;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;


    @GetMapping
    public ResponseEntity<List<Sportif>> getAllSportifs(){
        return ResponseEntity.ok(sportifService.getAllSportifs());
    }

    @GetMapping("/{id}")
    public Sportif getSportifByObjectId(@PathVariable String id){
        return this.sportifService.getSportifByObjectId(id);
    }

    @PostMapping
    public ResponseEntity addSportif(@RequestBody Sportif sportif){
        sportif.setIdSportif(sequenceGeneratorService.generateSequence(Sportif.SEQUENCE_NAME));
        sportifService.addSportif(sportif);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity updateSportif(@RequestBody Sportif sportif){
        sportifService.updateSportif(sportif);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSportif(@PathVariable String id){
        sportifService.deleteSportif(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
