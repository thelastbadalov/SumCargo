package az.sum.service;

import az.sum.dto.*;
import az.sum.dto.converter.OrderCoruierDtoConverter;
import az.sum.dto.converter.OrderDtoConverter;
import az.sum.exception.OrderNotFoundException;
import az.sum.model.Order;
import az.sum.model.Status;
import az.sum.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final PersonService personService;
    private final OrderCoruierDtoConverter orderCoruierDtoConverter;
    private final CourierService courierService;
    private final OrderDtoConverter converter;

    public OrderDto createOrder(CreateOrderRequest request) {
        personService.checkUserExistOrNot(request.getUserMail());
        Order order = new Order(
                request.getName(),
                request.getDestination(),
                Status.ORDERED,
                request.getUserMail());

        return converter.convert(orderRepository.save(order));
    }

    public List<OrderDto> getAllOrdersByUserMail(String mail) {
        return converter.convert(orderRepository.findAllByUserMail(mail));
    }

    public List<OrderDto> getAllOrders() {
        return converter.convert(orderRepository.findAll());
    }

    public OrderDto getOrderById(Long id) {
        return converter.convert(findOrderById(id));
    }

    public OrderDto updateOrderDesitination(Long id, UpdateOrderDestinationRequest request) {
        Order order = findOrderById(id);
        order.setDestination(request.getDestination());
        return converter.convert(orderRepository.save(order));
    }

    public void deleteOrderById(Long id) {
        findOrderById(id);
        orderRepository.deleteById(id);
    }

public OrderCourierDto assignOrderToCourier(Long id, AssignOrderToCourierRequest request){
Order order=findOrderById(id);
courierService.changeCourierStatus(request.getCourierMail());
order.setCourierMail(request.getCourierMail());
order.setStatus(Status.IN_COURIER);
return orderCoruierDtoConverter.convert(orderRepository.save(order));
}
public List<OrderCourierDto> getAllAsignedOrderByCoruierMail(String mail){
        courierService.findCourierByMail(mail);
        return orderCoruierDtoConverter.convert(orderRepository.findAllByCourierMail(mail));
}

public OrderCourierDto changeOrderStatus(Long id,UpdateOrderStatusRequest request){
Order order=findOrderById(id);
order.setStatus(Status.valueOf(request.getStatus()));
return orderCoruierDtoConverter.convert(order);
}
    protected Order findOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new OrderNotFoundException("can not find order with given id " + id));
    }

}

