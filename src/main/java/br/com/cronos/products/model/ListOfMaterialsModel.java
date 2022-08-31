package br.com.cronos.products.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="list_of_materiasl")
@Getter
@Setter
public class ListOfMaterialsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float necessaryAmount;

    @ManyToOne
    private ProductModel product;

    @ManyToOne
    private FeedstockModel feedstock;

    public ListOfMaterialsModel(float necessaryAmount, ProductModel product, FeedstockModel feedstock) {
        this.necessaryAmount = necessaryAmount;
        this.product = product;
        this.feedstock = feedstock;
    }

    public ListOfMaterialsModel() {
    }




}
