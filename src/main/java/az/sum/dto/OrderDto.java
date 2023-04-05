package az.sum.dto;

import az.sum.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private String name;
    private String destination;
    private Status status;
    private String userMail;
}
