package application;

import core.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TicketManagementServiceImpl implements TicketManagementService {
    private TicketRepository ticketRepository;
    private UserRepository userRepository;
    private OrderRepository orderRepository;

    public TicketManagementServiceImpl(TicketRepository ticketRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.addTicket(ticket);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.updateTicket(ticket);
    }

    @Override
    public void deleteTicket(int ticketId) {
        ticketRepository.deleteTicket(ticketId);
    }

    @Override
    public Ticket getAllTickets() {
        return ticketRepository.getAllTickets();
    }

    @Override
    public List<Ticket> getValidTickets(Date date) {
        List<Ticket> validTickets = new ArrayList<>();
        for (Ticket ticket : ticketRepository.getAllTickets()) {
            if (ticket.isValid(date)) {
                validTickets.add(ticket);
            }
        }
        return validTickets;
    }

    @Override
    public void addToCart(User user, Ticket ticket) {
        user.addToCart(ticket);
    }

    @Override
    public void createOrder(User user) {
        Order order = new Order((User) user.getCart());
        orderRepository.createOrder(order);
        user.clearCart();
    }

    @Override
    public void generateInvoice(User user, int orderId) {
        Order order = orderRepository.getOrderById(orderId);
        if (order != null && order.getUser().equals(user)) {
            Invoice invoice = new Invoice(order);
            invoice.generatePDF();
        }
    }

    @Override
    public void exportTicketsToExcel(String genre, String filePath) {
        List<Ticket> ticketsByGenre = ticketRepository.getTicketsByGenre(genre);
        ExcelExporter.exportTickets(ticketsByGenre, filePath);
    }
}

