package com.simplon.storedvd.controller.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class ClientDTO  {
        private Long id;
        private String nom;
        private String prenom;
        private String adresse;

    }

