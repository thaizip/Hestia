package hestia.msStore.payload;

import hestia.msStore.model.Lista;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank
    private String categoryName;

    @NotBlank
    private Set<Lista> lists;

}