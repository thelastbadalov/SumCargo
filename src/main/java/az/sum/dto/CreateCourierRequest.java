package az.sum.dto;

import az.sum.model.CourierStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCourierRequest {
    private String mail;
    private String firstName;
    private String lastName;
    private String password;
    private CourierStatus status;
}
