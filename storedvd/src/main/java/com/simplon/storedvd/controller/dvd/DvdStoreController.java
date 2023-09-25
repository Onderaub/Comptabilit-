package com.simplon.storedvd.controller.dvd;

import com.simplon.storedvd.exceptions.DvdNotFoundException;
import com.simplon.storedvd.services.dvd.DvdServiceModel;
import com.simplon.storedvd.services.dvd.DvdStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RequestMapping("dvds")
@RestController
public class DvdStoreController {

    @Autowired // Instancie "new="
    DvdStoreService dvdStoreService;

    // methode Post
    @PostMapping
    public boolean add(@RequestBody DvdStoreDTO dvdStoreDTO) {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.getName(), dvdStoreDTO.getGenre());
        return dvdStoreService.add(dvdServiceModel);
    }

    @PutMapping("/{id}")
    public boolean updateById(@RequestBody DvdStoreDTO dvdStoreDTO, @PathVariable Long id) {    // lis id dans l'url

        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.getName(), dvdStoreDTO.getGenre());
         return dvdStoreService.update(id,dvdServiceModel);


        // try {
        //    DvdServiceModel dvdServiceModel = dvdStoreService.findById(id);
        //    dvdStoreDTO.setId(id);
          //  dvdStoreDTO.setName(dvdServiceModel.getName());
          //  dvdStoreDTO.setGenre(dvdServiceModel.getGenre());
          //  dvdStoreService.update(dvdStoreDTO);
           // return new ResponseEntity<>(HttpStatus.OK);

        //} catch (DvdNotFoundException ex) {

          //  throw new ResponseStatusException(
            //        HttpStatus.NOT_FOUND, ex.getReason());

       // }
    }

    @GetMapping //
    public ArrayList<DvdStoregetDTO> findAll() {
        ArrayList<DvdStoregetDTO> dvdStoreDTOs = new ArrayList<>();
        ArrayList<DvdServiceModel> dvdServiceModels = dvdStoreService.findAll();
        dvdServiceModels.forEach((item) -> dvdStoreDTOs.add(new DvdStoregetDTO(item.getId().get(), item.getName(), item.getGenre())));

        return dvdStoreDTOs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreDTO> findById(@PathVariable Long id) {    // lis id dans l'url

        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();

        try {
            DvdServiceModel dvdServiceModel = dvdStoreService.findById(id);
            dvdStoreDTO.setId(id);
            dvdStoreDTO.setName(dvdServiceModel.getName());
            dvdStoreDTO.setGenre(dvdServiceModel.getGenre());
            return new ResponseEntity<>(dvdStoreDTO, HttpStatus.OK);

        } catch (DvdNotFoundException ex) {

            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getReason());

        }

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DvdStoreDTO> findByName(@PathVariable String name) {
        // Appeler le service pour rechercher le film par nom
        DvdServiceModel foundDvd = dvdStoreService.findByName(name);

        if (foundDvd != null) {
            DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();
            dvdStoreDTO.setId(foundDvd.getId().get());
            dvdStoreDTO.setName(foundDvd.getName());
            dvdStoreDTO.setGenre(foundDvd.getGenre());

            return new ResponseEntity<>(dvdStoreDTO, HttpStatus.OK);
        } else {
            // Gérez le cas où aucun film avec le nom spécifié n'a été trouvé
            // Vous pouvez choisir de renvoyer une réponse HTTP 404 ou un message d'erreur approprié.
            return ResponseEntity.notFound().build(); // Réponse HTTP 404
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean success = dvdStoreService.deleteById(id);

        if (success) {
            return ResponseEntity.status(HttpStatus.OK).build(); // Succès (HTTP 200)
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // Non trouvé (HTTP 404)
        }
    }


}




