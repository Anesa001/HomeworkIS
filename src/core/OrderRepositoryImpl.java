package core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRepositoryImpl implements OrderRepository {
    private Map<Integer, Order> orders;

    public OrderRepositoryImpl() {
        this.orders = new HashMap<>();
    }

    @Override
    public void createOrder(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public Order getOrderById(int orderId) {
        return orders.get(orderId);
    }

    @Override
    public List<Order> getOrdersByUser(User user) {
        List<Order> userOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getUser().equals(user)) {
                userOrders.add(order);
            }
        }
        return userOrders;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders.values());
    }
}
