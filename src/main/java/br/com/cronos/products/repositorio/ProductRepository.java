package br.com.cronos.products.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cronos.products.model.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>{
    
}
