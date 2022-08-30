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

import br.com.cronos.products.model.ProductModel;
import br.com.cronos.products.model.ResponseModel;
import br.com.cronos.products.service.ProductService;

@RestController
public class ProductControl {

    @Autowired
    private ProductService ps;

    @DeleteMapping("/remove/{code}")
    public ResponseEntity<ResponseModel> remove(@PathVariable long code){
        return ps.remove(code);

    }

    @PutMapping("/change")
    public ResponseEntity<?> change(@RequestBody ProductModel pm){
        return ps.registerOrChange(pm, "change");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ProductModel pm){
        return ps.registerOrChange(pm, "register");
    }

    @GetMapping("/list")
    public Iterable<ProductModel> list(){
        return ps.list();

    }

    @GetMapping("/")
    public String rota() {
        return "API FUNCIONANDO";
    }
    
}
