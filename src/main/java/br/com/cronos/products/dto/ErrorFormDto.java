package br.com.cronos.products.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorFormDto {

    private String campo;
    private String erro;
    public ErrorFormDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }
}
