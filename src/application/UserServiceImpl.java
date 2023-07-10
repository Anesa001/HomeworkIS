package application;

import core.*;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public UserServiceImpl(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public User loginUser(String email, String password) {
        return userRepository.getUserByEmailAndPassword(email, password);
    }

    @Override
    public void registerUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderRepository.getOrdersByUser(user);
    }

    @Override
    public void generateInvoicePDF(User user, int orderId, String filePath) {
        Order order = orderRepository.getOrderById(orderId);
        if (order != null && order.getUser().equals(user)) {
            Invoice invoice = new Invoice(order);
            invoice.generatePDF(filePath);
        }
    }
}
