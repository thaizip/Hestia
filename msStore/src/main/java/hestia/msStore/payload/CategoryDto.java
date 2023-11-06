package hestia.msStore.payload;

import hestia.msStore.model.Lista;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull(message = "The categoryName is null")
    private String categoryName;

    @NotNull(message = "The lists is null")
    private Set<Lista> lists;

}