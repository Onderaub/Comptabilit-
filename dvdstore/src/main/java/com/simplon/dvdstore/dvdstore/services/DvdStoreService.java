package com.simplon.dvdstore.dvdstore.services;

import com.simplon.dvdstore.dvdstore.DvdModel;
import com.simplon.dvdstore.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DvdStoreService implements DvdService {
    private final DvdStoreRepository dvdStoreRepository;
    @Autowired
    public DvdStoreService(DvdStoreRepository dvdStoreRepository){
        this.dvdStoreRepository= dvdStoreRepository;

    }

    @Override
    public List<DvdModel> getDvdsList() {
        return  dvdStoreRepository.list();
    }


}
