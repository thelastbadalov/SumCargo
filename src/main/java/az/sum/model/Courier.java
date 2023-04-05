package az.sum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(unique = true)
private String mail;
private String firstName;
private String lastName;
private String password;
private Role role;
private CourierStatus status;

    public Courier(String mail, String firstName, String lastName, String password, Role role, CourierStatus status) {
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.role = role;
        this.status = status;
    }
}
