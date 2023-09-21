package com.simplon.storedvd.repositories.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
@Table(name="client")
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name= "adresse")
    private String adresse;


    public ClientRepositoryModel(String nom, String prenom) {
        this.nom=nom;
        this.prenom=prenom;
    }

    public ClientRepositoryModel(String nom, String prenom, String adresse) {
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
    }
}
