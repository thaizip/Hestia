package hestia.msStore.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("name")
    private String listaname;

    @NotNull(message = "The data is null")
    @JsonProperty("data")
    private Date data;

//    @NotNull(message = "The products is null")
    @JsonProperty("products")
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}