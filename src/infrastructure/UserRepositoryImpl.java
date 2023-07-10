package infrastructure;

import core.User;
import core.UserRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {
    private Map<Integer, User> users;

    public UserRepositoryImpl() {
        this.users = new HashMap<>();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUserById(int id) {
        return users.get(id);
    }

    public User getUserByEmail(String email) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }



    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(int id) {
        users.remove(id);
    }

    public void exportUsersToExcel(List<User> users, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Users");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Email");
            headerRow.createCell(2).setCellValue("Role");

            // Populate data rows
            int rowNum = 1;
            for (User user : users) {
                Row dataRow = sheet.createRow(rowNum++);
                dataRow.createCell(0).setCellValue(user.getId());
                dataRow.createCell(1).setCellValue(user.getEmail());
                dataRow.createCell(2).setCellValue(user.getRole());
            }

            // Write workbook to file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importUsersFromExcel(String filePath) {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileIn)) {
            Sheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                int id = (int) row.getCell(0).getNumericCellValue();
                String email = row.getCell(1).getStringCellValue();
                String role = row.getCell(2).getStringCellValue();

                User user = new User(id, email, "", role);
                addUser(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        return null;
    }
}

