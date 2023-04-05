package az.sum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName, String mail, Role role, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.role = role;
        this.password = password;
    }

    @Column(unique = true)
    private String mail;

    public Person(String firstName, String lastName, String mail, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
    }

    private Role role;
    private String password;

}
