package hestia.msStore.payload;

import hestia.msStore.model.Product;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class ListaDto {

    @NotNull(message = "The listaname is null")
    private String listaname;

    @NotNull(message = "The data is null")
    private Date data;

    @NotNull(message = "The products is null")
    private List<Product> products;

}