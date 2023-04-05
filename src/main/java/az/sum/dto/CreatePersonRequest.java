package az.sum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String mail;

}
