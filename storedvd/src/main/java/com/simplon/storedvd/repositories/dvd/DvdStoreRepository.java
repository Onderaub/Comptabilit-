package com.simplon.storedvd.repositories.dvd;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;


public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel,Long> {

   // void deleteById(Long id);

    ArrayList<DvdRepositoryModel>findAll();
    Optional<DvdRepositoryModel> findById(Long id);


    @Modifying
    @Query("UPDATE DvdRepositoryModel d SET d.name = :name, d.genre = :genre WHERE d.id = :id")




    Optional<DvdRepositoryModel> findByName(String name);
}
