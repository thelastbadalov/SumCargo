package az.sum.repository;

import az.sum.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
List<Order> findAllByUserMail(String mail);
List<Order> findAllByCourierMail(String mail);
}
