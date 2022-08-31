package br.com.cronos.products.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cronos.products.model.ListOfMaterialsModel;

@Repository
public interface ListOfMaterialsRepository extends CrudRepository<ListOfMaterialsModel, Long> {
    
}
