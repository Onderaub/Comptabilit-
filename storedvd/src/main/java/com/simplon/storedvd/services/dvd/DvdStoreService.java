package com.simplon.storedvd.services.dvd;

import com.simplon.storedvd.repositories.dvd.DvdRepositoryModel;
import com.simplon.storedvd.repositories.dvd.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdStoreRepository;
    public boolean add(DvdServiceModel dvdServiceModel) {

        // Enregistre Le model dvd au format de la bdd en quantifiant les éléments Nom, Genre,

        DvdRepositoryModel dvdRepositoryModel=new DvdRepositoryModel(dvdServiceModel.getName(), dvdServiceModel.getGenre());

        // le sauvegarde dans le reposository
        DvdRepositoryModel dvdRepositoryModelReturned= dvdStoreRepository.save( dvdRepositoryModel);
        return dvdRepositoryModelReturned !=null;
    }
    public boolean update(Long id, DvdServiceModel dvdServiceModel) {

        DvdRepositoryModel dvdRepositoryModel=new DvdRepositoryModel(dvdServiceModel.getName(), dvdServiceModel.getGenre());
        dvdRepositoryModel.setId(id);

        DvdRepositoryModel dvdRepositoryModelReturned= dvdStoreRepository.save( dvdRepositoryModel);
        return dvdRepositoryModelReturned !=null;


    }

    public ArrayList<DvdServiceModel> findAll() {
ArrayList<DvdServiceModel> dvdServiceModels= new ArrayList<>();

ArrayList<DvdRepositoryModel> dvdRepositoryModels= dvdStoreRepository.findAll();
dvdRepositoryModels.forEach((item)->dvdServiceModels.add(new DvdServiceModel(Optional.ofNullable(item.getId()), item.getName(), item.getGenre())));
return dvdServiceModels;
    }


    public DvdServiceModel findById(Long id) {

        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if(dvdRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return new DvdServiceModel(dvdRepositoryModel.get().getName(),dvdRepositoryModel.get().getGenre());
        }
    }

    public boolean deleteById(Long id) {
        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if (dvdRepositoryModel.isPresent()) {
            // L'objet DVD avec l'ID spécifié a été trouvé, supprimerle de la base de données
            dvdStoreRepository.deleteById(id);
            return true; // Suppression réussie
        } else {
            return false; // L'objet avec l'ID spécifié n'a pas été trouvé
        }
    }




    public DvdServiceModel findByName(String name) {
        // Utiliser le repository pour rechercher le DVD par nom
        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findByName(name);

        if (dvdRepositoryModel != null) {
            // Si un DVD correspondant est trouvé, mapper-le vers un objet DvdServiceModel
            DvdServiceModel dvdServiceModel = new DvdServiceModel();
            dvdServiceModel.setId(Optional.ofNullable(dvdRepositoryModel.get().getId()));
            dvdServiceModel.setName(dvdRepositoryModel.get().getName());
            dvdServiceModel.setGenre(dvdRepositoryModel.get().getGenre());
            return dvdServiceModel;
        } else {

            return null;
        }
    }

}


