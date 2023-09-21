package com.simplon.storedvd.services.client;

import com.simplon.storedvd.repositories.client.ClientRepository;
import com.simplon.storedvd.repositories.client.ClientRepositoryModel;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Data
@Service
public class ClientService {
    @Autowired
    ClientRepository clientRepository;
    public boolean add(ClientServiceModel clientServiceModel) {

        // Enregistre Le model du client au format de la bdd en quantifiant les éléments Nom, prenom,
        ClientRepositoryModel clientRepositoryModel= new ClientRepositoryModel(clientServiceModel.getNom(), clientServiceModel.getPrenom(),clientServiceModel.getAdresse());


        // le sauvegarde dans le reposository
        ClientRepositoryModel clientRepositoryModelReturned= clientRepository.save( clientRepositoryModel);
        return clientRepositoryModelReturned !=null;
    }


    public boolean update(Long id, ClientServiceModel clientServiceModel) {
        ClientRepositoryModel clientRepositoryModel=new ClientRepositoryModel(clientServiceModel.getNom(),clientServiceModel.getPrenom());
        clientRepositoryModel.setId(id);

        ClientRepositoryModel clientRepositoryModelRetruned= clientRepository.save( clientRepositoryModel);
        return clientRepositoryModelRetruned !=null;
    }

    public ClientServiceModel findById(Long id) {
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(id);

        if(clientRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return new ClientServiceModel(clientRepositoryModel.get().getNom(),clientRepositoryModel.get().getPrenom());
        }
    }

    public ArrayList<ClientServiceModel> findAll() {
        ArrayList<ClientServiceModel> clientServiceModels= new ArrayList<>();

        ArrayList<ClientRepositoryModel>clientRepositorieModels= (ArrayList<ClientRepositoryModel>) clientRepository.findAll();
        clientRepositorieModels.forEach((item)->clientServiceModels.add(new ClientServiceModel(item.getId(), item.getPrenom(), item.getAdresse(), item.getNom())));
        return clientServiceModels;
    }

    public ClientServiceModel findByName(String nom) {
        Optional<ClientRepositoryModel>clientRepositoryModel = clientRepository.findByNom(nom);

        if(clientRepositoryModel != null) {
            ClientServiceModel clientServiceModel = new ClientServiceModel();
            clientServiceModel.setId(Optional.ofNullable(clientRepositoryModel.get().getId()));
            clientServiceModel.setNom(clientRepositoryModel.get().getNom());
            clientServiceModel.setPrenom(clientRepositoryModel.get().getPrenom());
            clientServiceModel.setAdresse(clientRepositoryModel.get().getAdresse());
            return clientServiceModel;
        }else{
            return null;
        }

    }
}
