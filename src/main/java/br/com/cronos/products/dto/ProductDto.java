package br.com.cronos.products.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.cronos.products.model.ProductModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto{

    private Long Id;
    private String name;
    private float value;

    public ProductDto(ProductModel product) {
        this.Id = product.getId();
        this.name = product.getName();
        this.value = product.getValue();
    }

    public static List<ProductDto> convert(List<ProductModel> products){
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
