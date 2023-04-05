package az.sum.controller;

import az.sum.dto.OrderCourierDto;
import az.sum.dto.UpdateOrderStatusRequest;
import az.sum.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/courier/order")
@RequiredArgsConstructor
public class CourierController {
private final OrderService orderService;

@GetMapping("/getAllAssignedOrders/{mail}")
public ResponseEntity<List<OrderCourierDto>> getAllAsignedOrders(@PathVariable String mail){
return ResponseEntity.ok(orderService.getAllAsignedOrderByCoruierMail(mail));
}

@PutMapping("/changeOrderStatus/{orderId}")
    public ResponseEntity<OrderCourierDto> changeOrderStatus(@PathVariable(name = "orderId") Long id, @RequestBody UpdateOrderStatusRequest request){
return ResponseEntity.ok(orderService.changeOrderStatus(id,request));
}
}
