package br.com.cronos.products.control;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronos.products.model.ListOfMaterialsForm;
import br.com.cronos.products.model.ListOfMaterialsModel;
import br.com.cronos.products.repository.FeedstockRepository;
import br.com.cronos.products.repository.ListOfMaterialsRepository;
import br.com.cronos.products.repository.ProductRepository;

@RestController
public class ListOfMaterialsControl {

    @Autowired
    private ListOfMaterialsRepository lr;

    @Autowired
    private ProductRepository pr;

    @Autowired
    private FeedstockRepository fr;

    @PostMapping("/listofmaterials")
    public ResponseEntity<ListOfMaterialsModel> register(@RequestBody @Valid ListOfMaterialsForm form){
        ListOfMaterialsModel list = form.convert(pr, fr);
        return new ResponseEntity<ListOfMaterialsModel>(lr.save(list), HttpStatus.CREATED);
    }

    
}