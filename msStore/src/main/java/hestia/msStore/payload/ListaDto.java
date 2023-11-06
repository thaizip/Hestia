package hestia.msStore.payload;

import hestia.msStore.model.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaDto {

    @NotBlank
    private String listaname;

    @NotBlank
    private Date data;

    @NotBlank
    private List<Product> products;

}