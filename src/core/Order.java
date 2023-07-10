package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private static int counter = 0;
    private int id;
    private User user;
    private List<Ticket> tickets;
    private Date orderDate;

    public Order(User user) {
        this.id = ++counter;
        this.user = user;
        this.tickets = new ArrayList<>();
        this.orderDate = new Date();
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}

