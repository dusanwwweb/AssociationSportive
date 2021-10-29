package com.dusanweb.sprotif.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Getter
@Setter
public class Sport {
    @Field(name = "Jouer")
    private List<String> jouer;
    @Field(name = "Arbitrer")
    private List<String> arbitrer;
    @Field(name = "Entrainer")
    private List<String> entrainer;
}
