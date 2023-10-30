package prjIntegrador.hestia.payload;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonBussDTO {

    @NotNull
    @CNPJ(message = "Cnpj is not valid")
    @Size(min = 11, max = 14,message = "The CNPJ ins't in the correct size")
    private String cnpj;

    @NotNull
    private String endereco;

    @NotNull
    @Size(min = 3, max = 5,message = "O numero deve ter exatamente 5 dígitos.")
    private String numero;

    @NotNull
    private String bairro;

    @NotNull
    private String cidade;

    @NotNull
    @Size(max = 2, message = "UF deve ter no máximo 2 caracteres.")
    private String uf;

    @NotNull
    private String name;

    @NotNull
    private String personImg;

    @NotNull
    @Email(message = "The email must be a well-formed email address")
    private String email;

    @NotNull
    private String password;

}