package br.com.cronos.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cronos.products.model.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long>{
    
}
