package az.sum.dto.converter;

import az.sum.dto.CourierDto;
import az.sum.dto.RoleDto;
import az.sum.model.Courier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CourierDtoConverter {

public CourierDto convertToDto(Courier courier){
return new CourierDto(courier.getMail(), courier.getFirstName(),courier.getLastName(),
        RoleDto.valueOf(courier.getRole().name()),courier.getStatus());
}
public List<CourierDto> convert(List<Courier> courier){
return courier.stream().map(this::convertToDto).collect(Collectors.toList());
}
}
