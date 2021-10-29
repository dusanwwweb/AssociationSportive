package com.dusanweb.sprotif.repository;

import com.dusanweb.sprotif.model.Sportif;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SportifRepository extends MongoRepository<Sportif, String> { }
