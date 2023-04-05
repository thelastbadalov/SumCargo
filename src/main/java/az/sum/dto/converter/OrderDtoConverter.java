package az.sum.dto.converter;

import az.sum.dto.CreateOrderRequest;
import az.sum.dto.OrderDto;
import az.sum.model.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderDtoConverter {

    public OrderDto convert(Order request){
        return new OrderDto(
                request.getId(),
                request.getName(),
                request.getDestination(),
                request.getStatus(),
                request.getUserMail());
    }


    public List<OrderDto> convert(List<Order> request){
return request.stream().map(this::convert).collect(Collectors.toList());
      }
}
