package br.com.cronos.products.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.cronos.products.model.FeedstockModel;
import br.com.cronos.products.model.ResponseModel;
import br.com.cronos.products.repository.FeedstockRepository;

@Service
public class FeedstockService {
    

    @Autowired
    private FeedstockRepository fr;

    @Autowired
    private ResponseModel rm;

    public Iterable<FeedstockModel> list(){
        return fr.findAll();
    }

    public ResponseEntity<?> registerOrChange(FeedstockModel fm, String action){
        if(fm.getName().equals("")){
            rm.setMessage("Name is required");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else if(fm.getQuantity() == 0) {
            rm.setMessage("Quantify is required");
            return new ResponseEntity<ResponseModel>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(action.equals("register")) {
                return new ResponseEntity<FeedstockModel>(fr.save(fm), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<FeedstockModel>(fr.save(fm), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<ResponseModel> remove(long code){
        fr.deleteById(code);
        rm.setMessage("Object removed.");
        return new ResponseEntity<ResponseModel>(rm, HttpStatus.OK);
    }
}
