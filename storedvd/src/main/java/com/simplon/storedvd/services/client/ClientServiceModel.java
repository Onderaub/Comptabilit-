package com.simplon.storedvd.services.client;

import com.simplon.storedvd.repositories.client.ClientRepository;
import com.simplon.storedvd.repositories.client.ClientRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientServiceModel {
    private Optional<Long>id;
    private String nom;
    private String prenom;
    private String adresse;

    @Autowired
    ClientRepository clientRepository;
    public ClientServiceModel(String nom, String prenom) {
        this.nom=nom;
        this.prenom=prenom;


    }

    public ClientServiceModel(String nom, String prenom, String adresse) {
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
    }

    public ClientServiceModel(Long id, String prenom, String adresse, String nom) {
        this.id= id.describeConstable();
        this.nom=nom;
        this.prenom=prenom;
        this.adresse=adresse;
    }
}
