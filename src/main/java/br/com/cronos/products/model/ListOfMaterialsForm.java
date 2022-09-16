package br.com.cronos.products.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.cronos.products.repository.FeedstockRepository;
import br.com.cronos.products.repository.ProductRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListOfMaterialsForm {

    @NotNull @NotEmpty
    private float necessaryAmount;
    @NotNull @NotEmpty
    private Long productId;
    @NotNull @NotEmpty
    private Long feedstockId;

    public ListOfMaterialsModel convert(ProductRepository pr, FeedstockRepository fr) {

        ProductModel product = pr.findById(productId).get();
        FeedstockModel feedstock = fr.findById(feedstockId).get();


        return new ListOfMaterialsModel(necessaryAmount, product, feedstock);
    }
}
