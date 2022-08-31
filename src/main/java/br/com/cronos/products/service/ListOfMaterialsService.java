package br.com.cronos.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cronos.products.model.ListOfMaterialsModel;
import br.com.cronos.products.repository.ListOfMaterialsRepository;

@Service
public class ListOfMaterialsService {

    @Autowired
    private ListOfMaterialsRepository lr;


    public ResponseEntity<ListOfMaterialsModel> register(ListOfMaterialsModel lm){
    
        return new ResponseEntity<ListOfMaterialsModel>(lr.save(lm), HttpStatus.CREATED);
    }
}
