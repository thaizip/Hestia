package prjIntegrador.hestia.payload;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank @Email(message = "Email is not falited")
    private String email;

    @NotBlank @Size(min = 6, max = 8)
    private String password;

}