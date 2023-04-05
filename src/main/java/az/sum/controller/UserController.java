package az.sum.controller;

import az.sum.dto.CreateOrderRequest;
import az.sum.dto.OrderDto;
import az.sum.dto.UpdateOrderDestinationRequest;
import az.sum.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user/order")
@RequiredArgsConstructor
public class UserController {
private final OrderService orderService;

@PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody CreateOrderRequest request){
    return ResponseEntity.ok(orderService.createOrder(request));
}
@PutMapping("/{orderId}")
    public ResponseEntity<OrderDto> updateOrderDestination(@PathVariable (name = "orderId") Long id, @RequestBody UpdateOrderDestinationRequest request){
    return ResponseEntity.ok(orderService.updateOrderDesitination(id,request));
}
@GetMapping("/{mail}")
    public ResponseEntity<List<OrderDto>> getAllOrders(@PathVariable String mail){

    return ResponseEntity.ok(orderService.getAllOrdersByUserMail(mail));
}
    @GetMapping("/getOrderById/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @DeleteMapping("/deleteOrderById/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrderById(id);
        return ResponseEntity.ok().build();
    }
}


