package az.sum.dto;

import az.sum.model.CourierStatus;
import az.sum.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierDto {
    private String mail;
    private String firstName;
    private String lastName;
    private RoleDto role;
    private CourierStatus status;
}
