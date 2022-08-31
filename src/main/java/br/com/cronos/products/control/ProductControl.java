package br.com.cronos.products.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cronos.products.dto.ProductDto;
import br.com.cronos.products.model.ProductModel;
import br.com.cronos.products.model.ResponseModel;
import br.com.cronos.products.service.ProductService;

@RestController
public class ProductControl {

    @Autowired
    private ProductService ps;

    @DeleteMapping("/product/{code}")
    public ResponseEntity<ResponseModel> remove(@PathVariable long code){
        return ps.remove(code);
    }

    @PutMapping("/product")
    public ResponseEntity<?> change(@RequestBody ProductModel pm){
        return ps.registerOrChange(pm, "change");
    }

    @PostMapping("/product")
    public ResponseEntity<?> register(@RequestBody ProductModel pm){
        return ps.registerOrChange(pm, "register");
    }


    @GetMapping("/product")
    public List<ProductDto> list(){
        return ps.list();
    }

    // @GetMapping("/product")
    // public Iterable<ProductModel> listById(String listByValue){
    //     return ps.list(listByValue);
    // }

    @GetMapping("/")
    public String rota() {
        return "API FUNCIONANDO";
    }
    
}
