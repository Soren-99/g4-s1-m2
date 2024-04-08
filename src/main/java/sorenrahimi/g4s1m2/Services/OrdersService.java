package sorenrahimi.g4s1m2.Services;

import org.springframework.beans.factory.annotation.Autowired;
import sorenrahimi.g4s1m2.Exceptions.NotFoundException;
import sorenrahimi.g4s1m2.Repositories.OrdersDAO;
import sorenrahimi.g4s1m2.entities.MenuItem;
import sorenrahimi.g4s1m2.entities.Order;

import java.util.List;
import java.util.NoSuchElementException;

public class OrdersService {
    @Autowired
    OrdersDAO ordersDAO;

    public List<Order> getAll() {
        return ordersDAO.findAll();
    }
    public Order findById(long id) {
        return ordersDAO.findById(id).orElseThrow(
                () ->new NotFoundException(id));
    }
    public void save(Order order){
        ordersDAO.save(order);
    }
    public void findByIdAndDelete(long id){
        Order order = this.findById(id);
        ordersDAO.delete(order);
    }
}
