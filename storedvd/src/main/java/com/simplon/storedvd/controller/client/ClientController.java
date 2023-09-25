package com.simplon.storedvd.controller.client;

import com.simplon.storedvd.controller.dvd.DvdStoreDTO;
import com.simplon.storedvd.exceptions.ClientNotFoundException;
import com.simplon.storedvd.services.client.ClientService;
import com.simplon.storedvd.services.client.ClientServiceModel;
import com.simplon.storedvd.services.dvd.DvdServiceModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RequestMapping("dvds")
@RestController
public class ClientController {
@Autowired
ClientService clientService;


// Ajouter modifier un Client
@PostMapping("/user")
    public boolean add(@RequestBody ClientDTO clientDTO){
    ClientServiceModel clientServiceModel= new ClientServiceModel(clientDTO.getNom(),clientDTO.getPrenom(), clientDTO.getAdresse());
    return clientService.add(clientServiceModel);
}
@PutMapping("/user/{id}")
public boolean update(@RequestBody ClientDTO clientDTO,@PathVariable Long id){

    ClientServiceModel clientServiceModel=new ClientServiceModel(clientDTO.getNom(), clientDTO.getPrenom());
    return clientService.update(id,clientServiceModel);
}



// Methode Get pour afficher les clients ou rechercher par id et par Nom


    @GetMapping("/user/all")
    public ArrayList<ClientDTO> findAll(){

    ArrayList<ClientDTO> clientDTOs= new ArrayList<>();
    ArrayList<ClientServiceModel> clientServiceModels = clientService.findAll();
    clientServiceModels.forEach((item)->clientDTOs.add(new ClientDTO(item.getId().get(),item.getNom(),item.getPrenom(), item.getAdresse())));
    return clientDTOs;
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {    // lis id dans l'url

ClientDTO clientDTO= new ClientDTO();
try{
    ClientServiceModel clientServiceModel=clientService.findById(id);
    clientDTO.setId(id);
    clientDTO.setNom(clientServiceModel.getNom());
    clientDTO.setAdresse(clientServiceModel.getAdresse());
    clientDTO.setPrenom(clientServiceModel.getPrenom());
    return new ResponseEntity<>(clientDTO, HttpStatus.OK);



}catch(ClientNotFoundException ex){
    throw new ResponseStatusException(
            HttpStatus.NOT_FOUND, ex.getReason);
        }
    }
    @GetMapping("/user/{nom}")
    public ResponseEntity<ClientDTO> findByName(@PathVariable String nom) {
        // Appeler le service pour rechercher le client par nom
        ClientServiceModel foundCustomer = clientService.findByName(nom);

        if (foundCustomer != null) {
            ClientDTO clientDTO = new ClientDTO();
            clientDTO.setId(foundCustomer.getId().get());
            clientDTO.setNom(foundCustomer.getNom());
            clientDTO.setPrenom(foundCustomer.getPrenom());

            return new ResponseEntity<>(clientDTO, HttpStatus.OK);
        } else {
            // Gérez le cas où aucun film avec le nom spécifié n'a été trouvé
            // Vous pouvez choisir de renvoyer une réponse HTTP 404 ou un message d'erreur approprié.
            return ResponseEntity.notFound().build(); // Réponse HTTP 404
        }
    }

}
