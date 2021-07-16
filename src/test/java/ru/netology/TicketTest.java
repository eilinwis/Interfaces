package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.domain.TimeComparator;
import ru.netology.manager.TicketManager;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketTest {
    private TicketRepository ticketRepository = new TicketRepository();
    private TicketManager ticketManager = new TicketManager(ticketRepository);
    private TimeComparator timeComparator = new TimeComparator();
    private Ticket first = new Ticket(1, 2000, "LED", "KVK", 200);
    private Ticket second = new Ticket(2, 3000, "VKO", "KUF", 120);
    private Ticket third = new Ticket(3, 1500, "SVO", "KVK", 80);
    private Ticket fourth = new Ticket(4, 2500, "RVH", "FRU", 90);
    private Ticket fifth = new Ticket(5, 500, "LED", "GOJ", 95);
    private Ticket sixth = new Ticket(6, 3000, "LED", "KVK", 90);
    private Ticket seventh = new Ticket(7, 3200, "RVH", "FRU", 100);
    private Ticket eighth = new Ticket(8, 2700, "LED", "KVK", 220);
    private Ticket ninth = new Ticket(9, 1800, "LED", "KVK", 80);
    private Ticket tenth = new Ticket(10, 3500, "LED", "KVK", 79);
    private Ticket eleventh = new Ticket(11, 2350, "LED", "KVK", 150);
    private Ticket twelfth = new Ticket(12, 2100, "LED", "KVK", 250);
    private Ticket thirteenth = new Ticket(13, 3900, "RVH", "FRU", 300);
    private Ticket fourteenth = new Ticket(14, 7800, "RVH", "FRU", 120);
    private Ticket fifteenth = new Ticket(15, 1500, "RVH", "FRU", 250);
    private Ticket sixteenth = new Ticket(16, 2500, "RVH", "FRU", 180);
    private Ticket seventeenth = new Ticket(17, 3000, "RVH", "FRU", 200);


    @BeforeEach
    public void shouldAdd() {
        ticketManager.add(first);
        ticketManager.add(second);
        ticketManager.add(third);
        ticketManager.add(fourth);
        ticketManager.add(fifth);
        ticketManager.add(sixth);
        ticketManager.add(seventh);
        ticketManager.add(eighth);
        ticketManager.add(ninth);
        ticketManager.add(tenth);
        ticketManager.add(eleventh);
        ticketManager.add(twelfth);
        ticketManager.add(thirteenth);
        ticketManager.add(fourteenth);
        ticketManager.add(fifteenth);
        ticketManager.add(sixteenth);
        ticketManager.add(seventeenth);
    }


    @Test
    void shouldSortByPrice() {
        Ticket[] actual = new Ticket[]{first, second, third, fourth, fifth};
        Ticket[] expected = new Ticket[]{fifth, third, first, fourth, second};

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);

    }


    @Test
    void shouldFindLEDtoKVKAndSort() {
        Ticket[] expected = new Ticket[]{ninth, first, twelfth, eleventh, eighth, sixth, tenth};
        Ticket[] actual = ticketManager.searchByAirports("LED", "KVK");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindRVHtoFRUAndSort() {
        Ticket[] expected = new Ticket[]{fifteenth, fourth, sixteenth, seventeenth, seventh, thirteenth, fourteenth};
        Ticket[] actual = ticketManager.searchByAirports("RVH", "FRU");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFound() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = ticketManager.searchByAirports("RGH", "FAU");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindRVHtoFRUAndSortByTime() {
        Ticket[] expected = new Ticket[]{fourth, seventh, fourteenth, sixteenth, seventeenth, fifteenth, thirteenth};
        Ticket[] actual = ticketManager.searchByAirports2("RVH", "FRU", timeComparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLEDtoKVKAndSortByTime() {
        Ticket[] expected = new Ticket[]{tenth, ninth, sixth, eleventh, first, eighth, twelfth};
        Ticket[] actual = ticketManager.searchByAirports2("LED", "KVK", timeComparator);
        assertArrayEquals(expected, actual);
    }
}



