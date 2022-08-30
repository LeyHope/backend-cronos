package br.com.cronos.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cronos.products.model.ProductModel;
import br.com.cronos.products.model.ResponseModel;
import br.com.cronos.products.repositorio.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository pr;

    @Autowired
    private ResponseModel rm;

    public Iterable<ProductModel> list(){
        return pr.findAll();
    }

    public ResponseEntity<?> registerOrChange(ProductModel pm, String action){
        if(pm.getName().equals("")){
            rm.setMessage("Name is required");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getQuantity() == 0) {
            rm.setMessage("Quantify is required");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(action.equals("register")) {
                return new ResponseEntity<ProductModel>(pr.save(pm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProductModel>(pr.save(pm), HttpStatus.OK);
            }
        }
    }


    public ResponseEntity<ResponseModel> remove(long code){
        pr.deleteById(code);
        rm.setMessage("Object removed.");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }




}
