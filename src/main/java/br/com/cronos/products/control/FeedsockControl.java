package br.com.cronos.products.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronos.products.model.FeedstockModel;
import br.com.cronos.products.model.ResponseModel;
import br.com.cronos.products.service.FeedstockService;

@RestController
public class FeedsockControl {

    @Autowired
    private FeedstockService fs;

    @DeleteMapping("/feedstock/{code}")
    public ResponseEntity<ResponseModel> remove(@PathVariable long code){
    return fs.remove(code);

    }

    @PutMapping("/feedstock")
    public ResponseEntity<?> change(@RequestBody FeedstockModel fm){
        return fs.registerOrChange(fm, "change");
    }

    @PostMapping("/feedstock")
    public ResponseEntity<?> register(@RequestBody FeedstockModel fm){
        return fs.registerOrChange(fm, "register");
    }

    @GetMapping("/feedstock")
    public Iterable<FeedstockModel> list(){
        return fs.list();
    }
    
}
