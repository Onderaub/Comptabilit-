package com.simplon.storedvd.services.dvd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.el.lang.ELArithmetic;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdServiceModel {
    private Optional<Long> id;
    private String name;
    private String genre;
    private int quantite;


    public DvdServiceModel(Optional<Long> id, String name, String genre) {
        this.id=id;
        this.name= name;
        this.genre=genre;
    }

    public DvdServiceModel(String name, String genre) {
        this.name= name;
        this.genre=genre;
    }
}
