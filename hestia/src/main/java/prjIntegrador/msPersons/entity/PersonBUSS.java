package prjIntegrador.msPersons.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @ToString
@Table(name = "Empressa")
public class PersonBUSS {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personBussId;

    @Column(name = "CNPJ")
    private String cnpj;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private String numero;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "UF")
    private String uf;

    @Column(name = "name")
    private String name;

    @Column(name = "personImg")
    private String personImg;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private boolean active;
}