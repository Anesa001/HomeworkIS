package application;

import core.Ticket;
import core.User;

import java.util.Date;
import java.util.List;

public interface TicketManagementService {
    void addTicket(Ticket ticket);

    void updateTicket(Ticket ticket);

    void deleteTicket(int ticketId);

    Ticket getAllTickets();

    List<Ticket> getValidTickets(Date date);

    void addToCart(User user, Ticket ticket);

    void createOrder(User user);

    void generateInvoice(User user, int orderId);

    void exportTicketsToExcel(String genre, String filePath);
}

