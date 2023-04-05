package az.sum.controller;

import az.sum.dto.*;
import az.sum.service.CourierService;
import az.sum.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/admin/order")
@RequiredArgsConstructor
public class AdminController {
    private final OrderService orderService;
    private final CourierService courierService;

    @PutMapping("/changeOrderStatus/{orderId}")
    public ResponseEntity<OrderCourierDto> changeOrderStatus(@PathVariable(name = "orderId") Long id, @RequestBody UpdateOrderStatusRequest request) {
        return ResponseEntity.ok(orderService.changeOrderStatus(id, request));
    }

    @PutMapping("/assignOrderToCourier/{orderId}")
    public ResponseEntity<OrderCourierDto> assignOrderToCourier(@PathVariable(name = "orderId") Long id, @RequestBody AssignOrderToCourierRequest request) {
        return ResponseEntity.ok(orderService.assignOrderToCourier(id, request));
    }

    @PostMapping("/createCourier")
    public ResponseEntity<CourierDto> createCourier(@RequestBody CreateCourierRequest request) {
        return ResponseEntity.ok(courierService.createCourier(request));
    }

    @GetMapping("/getALlCouriers")
    public ResponseEntity<List<CourierDto>> getAllCouriers() {
        return ResponseEntity.ok(courierService.getAllCouriers());
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
