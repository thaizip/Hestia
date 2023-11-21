package hestia.msStore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "Lista")
public class Lista {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listaId;

    @Column(name = "name")
    private String listaname;

    @Column(name = "data")
    private Date data;

    @ManyToMany(mappedBy = "lists")
    @Column(nullable = false)
    @JsonIgnore
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}