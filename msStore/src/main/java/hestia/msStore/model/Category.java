package hestia.msStore.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name = "Category")
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "category_name")
    private String categoryName;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int contains(int categoryId) {
        return categoryId;
    }

}