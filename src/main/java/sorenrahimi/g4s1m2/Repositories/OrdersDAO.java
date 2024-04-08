package sorenrahimi.g4s1m2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sorenrahimi.g4s1m2.entities.Order;

public interface OrdersDAO extends JpaRepository<Order, Long> {
}
