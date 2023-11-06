package hestia.msStore.payload;

import hestia.msStore.model.Category;
import hestia.msStore.model.Lista;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotBlank(message = "The product name should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    private String productName;

    @NotBlank(message = "The description should not be empty")
    @Size(min = 3, message = "Product description should have at least 3 characters")
    private String description;

    @NotBlank(message = "The img product should not be empty")
    private String imgUrl;

    @DecimalMin(value = "1",message = "The product price cant be less than 1")
    private BigDecimal price;

    @NotNull
    private Set<Category> categories;

}