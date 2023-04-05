package az.sum.dto.converter;

import az.sum.dto.OrderCourierDto;
import az.sum.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderCoruierDtoConverter {

public OrderCourierDto convert(Order order){
    return new OrderCourierDto(
            order.getId(),
            order.getName(),
            order.getDestination(),
            order.getStatus(),
            order.getCourierMail(),
            order.getUserMail()
    );
}
public List<OrderCourierDto> convert(List<Order> orders){
    return orders.stream().map(this::convert).collect(Collectors.toList());
}
}
