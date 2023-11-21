package hestia.msStore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@ToString
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

    public int getListaId() {
        return listaId;
    }

    public void setListaId(int listaId) {
        this.listaId = listaId;
    }

    public String getListaname() {
        return listaname;
    }

    public void setListaname(String listaname) {
        this.listaname = listaname;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}