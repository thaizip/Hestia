package prjIntegrador.msPersons.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Person" , uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class Person {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

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

    @Override
    public String toString() {
        return "person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", personImg='" + personImg + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}