package br.com.cronos.products.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products")
@Getter
@Setter
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    private float value;

    @OneToMany(mappedBy = "product")
    private List<ListOfMaterialsModel> listOfMaterials = new ArrayList<>();

    // public void addFeestock(ListOfMaterialsModel item){
    //     item.setProduct(this);
    //     this.listOfMaterials.add(item);
    // }

    public void listOfMaterials(List<ListOfMaterialsModel> list){
        this.listOfMaterials = list;

    }
    
}
