package lotto;

public class Ticket {

    public static final int TICKET_PRICE = 1000;

    public int getTicket(int money) {
        int ticket = 0;
        try {
            ticket = money / TICKET_PRICE;
        } catch (Exception e) {
            e.getStackTrace();
            System.out.println(Print.INSERT_MONEY_ERROR);
        }
        return ticket;
    }
}
