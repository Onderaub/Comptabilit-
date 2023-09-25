package com.simplon.storedvd.repositories.client;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientRepositoryModel,Long> {


    ClientRepositoryModel save(ClientRepositoryModel clientRepositoryModel);

    Optional<ClientRepositoryModel> findByNom(String nom);
}
