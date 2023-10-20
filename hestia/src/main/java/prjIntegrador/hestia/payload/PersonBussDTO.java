package prjIntegrador.hestia.payload;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CNPJ;
import prjIntegrador.hestia.util.ValitedCNPJ;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonBussDTO {

    @NotBlank @CNPJ(groups = ValitedCNPJ.class)
    @Size(min = 11, max = 14,message = "The CNPJ ins't in the correct size")
    private String CNPJ;

    @NotBlank
    private String endereco;

    @Size(min = 3, max = 5,message = "O numero deve ter exatamente 5 dígitos.")
    private String numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank
    @Size(max = 2, message = "UF deve ter no máximo 2 caracteres.")
    private String UF;

    @NotBlank
    private String name;

    @NotBlank
    private String personImg;

    @NotBlank
    @Email(message = "The email must be a well-formed email address")
    private String email;

    @NotBlank
    private String password;

}