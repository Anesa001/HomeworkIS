package core;

import java.util.List;

public interface OrderRepository {
    void createOrder(Order order);

    Order getOrderById(int orderId);

    List<Order> getOrdersByUser(User user);

    List<Order> getAllOrders();

    // Add any other methods as per your requirements
}

