package az.sum.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "orders")
public class Order {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String name;
private String destination;
private Status status;
private  String courierMail;

    public Order(String name, String destination, Status status, String userMail) {
        this.name = name;
        this.destination = destination;
        this.status = status;
        this.userMail = userMail;
    }

    private String userMail;



}
