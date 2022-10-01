import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {

    TicketRepository ticketRepository = new TicketRepository();
    TicketManager ticketManager = new TicketManager(ticketRepository);
    Ticket ticket1 = new Ticket(1,"MQF", "SVO",20000, 120);
    Ticket ticket2 = new Ticket(1,"MQF", "SVO",10000, 120);
    Ticket ticket3 = new Ticket(1,"MQF", "SVO",15000, 120);
    Ticket ticket4 = new Ticket(1,"CEK", "SVO",12000, 150);
    Ticket ticket5 = new Ticket(1,"MQF", "SVO",8000, 120);
    Ticket ticket6 = new Ticket(1,"MQF", "UFA",25000, 100);
    Ticket ticket7 = new Ticket(1,"MQF", "SVO",13000, 120);
    Ticket ticket8 = new Ticket(1,"CEK", "SVO",12000, 220);

    @BeforeEach
    public void setup() {
        ticketManager.add(ticket1);
        ticketManager.add(ticket2);
        ticketManager.add(ticket3);
        ticketManager.add(ticket4);
        ticketManager.add(ticket5);
        ticketManager.add(ticket6);
        ticketManager.add(ticket7);
        ticketManager.add(ticket8);
    }

    @Test
    public void testWhenFewTicketsFind(){

        Ticket[] expected = {ticket5, ticket2, ticket7, ticket3, ticket1 };
        Ticket[] actual = ticketManager.findAll("MQF", "SVO");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testWhenOneTicketFind(){

        Ticket[] expected = {ticket6};
        Ticket[] actual = ticketManager.findAll("MQF", "UFA");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testWhenTwoEqualTicketsFind(){

        Ticket[] expected = {ticket4, ticket8};
        Ticket[] actual = ticketManager.findAll("CEK", "SVO");

        Assertions.assertArrayEquals(expected, actual);

    }
}
