package prjIntegrador.hestia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Empressa")
public class PersonBUSS {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personBussId;

    @Column(name = "CNPJ")
    private int CNPJ;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private int numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "UF")
    private char UF;

    @Override
    public String toString() {
        return "PersonBUSS{" +
                "personBussId=" + personBussId +
                ", CNPJ=" + CNPJ +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", UF=" + UF +
                '}';
    }
}