package core;
import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();

    User getUserById(int id);

    User getUserByEmail(String email);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    void exportUsersToExcel(List<User> users, String filePath);

    void importUsersFromExcel(String filePath);

    User getUserByEmailAndPassword(String email, String password);
}
