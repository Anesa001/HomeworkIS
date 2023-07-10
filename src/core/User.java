package core;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String email;
    private String password;
    private String role;
    private List<Ticket> cart;

    public User(int id, String email, String password, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
        this.cart = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    // Additional methods as per the task requirements

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public void addToCart(Ticket ticket) {
        cart.add(ticket);
    }

    public List<Ticket> getCart() {
        return new ArrayList<>(cart);
    }

     public void clearCart() {
        cart.clear();
    }
}
