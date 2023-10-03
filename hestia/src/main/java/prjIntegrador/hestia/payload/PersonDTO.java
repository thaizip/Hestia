package prjIntegrador.hestia.payload;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "PersonDTO")
public class PersonDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String personImg;

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}