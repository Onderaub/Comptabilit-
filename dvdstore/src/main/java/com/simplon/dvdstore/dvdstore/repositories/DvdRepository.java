package com.simplon.dvdstore.dvdstore.repositories;

import com.simplon.dvdstore.dvdstore.DvdModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface DvdRepository {
    List<DvdModel> list();
    default List<DvdModel> loadMoviesFromFile(String file) { // la méthode loadMoviesFromFile() utilise les getters et
                                                  // setters générés par Lombok pour accéder aux propriétés de DvdModel

        List<DvdModel> dvds=new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            for(String line; (line = br.readLine()) != null; ) {
                final DvdModel dvd=new DvdModel();
                final String[] titreEtGenre = line.split(";");
                dvd.setName(titreEtGenre[0]);
                dvd.setGenre(titreEtGenre[1]);
                dvds.add(dvd);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dvds;
    }
}

