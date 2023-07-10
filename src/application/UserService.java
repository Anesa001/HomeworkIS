package application;

import core.Order;
import core.User;

import javax.management.relation.Role;
import java.util.List;

public interface UserService {
    User loginUser(String email, String password);

    void registerUser(User user);

    void updateUser(User user);

    List<Order> getUserOrders(User user);

    void generateInvoicePDF(User user, int orderId, String filePath);

    void registerUser(String email, String password);

    void updateUserRole(String email, Role newRole);

    List<User> getAllUsers();

    User getUserByEmail(String email);
}

