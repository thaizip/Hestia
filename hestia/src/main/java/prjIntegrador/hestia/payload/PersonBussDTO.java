package prjIntegrador.hestia.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonBussDTO {

    @NotBlank @Size(max = 14)
    private int CNPJ;

    @NotBlank
    private String endereco;

    @NotBlank
    private int numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String cidade;

    @NotBlank @Size(max = 2)
    private char UF;


}