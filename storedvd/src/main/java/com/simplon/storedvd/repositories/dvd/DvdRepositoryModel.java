package com.simplon.storedvd.repositories.dvd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="dvdstore")
public class DvdRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="genre")
    private String genre;
  //  @Column(name="quantite")
    // private int quantite;

    public DvdRepositoryModel(String name, String genre) {
        this.name = name;
        this.genre = genre;



    }

}

