package core;

import java.util.List;

public interface TicketRepository {
    Ticket getTicketById(int id);
    void addTicket(Ticket ticket);
    void updateTicket(Ticket ticket);
    void deleteTicket(int id);

    Ticket getAllTickets();

    List<Ticket> getTicketsByGenre(String genre);
}

