package az.sum.dto;

import az.sum.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCourierDto {
    private Long id;
    private String name;
    private String destination;
    private Status status;
    private  String courierMail;
    private String userMail;
}
