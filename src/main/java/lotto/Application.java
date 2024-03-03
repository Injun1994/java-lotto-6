package lotto;

import java.util.*;

public class Application {

    public static void main(String[] args) {

        Input input = new Input();
        Ticket ticket = new Ticket();
        Result result = new Result();

        int ticketPrice = input.inputAmount();
        int numberOfTicket = ticket.getTicket(ticketPrice);
        System.out.println("\n" + numberOfTicket + Print.NUMBER_OF_PURCHASE);

        Map<List<Integer>, Integer> lotteryNumberMap = new Lotto().getLotteryNumbersAndBonusNumber(numberOfTicket);
        WinningLotto winningLotto = new WinningLotto(input.inputLotteryNumbers(), input.inputBonusNumber());

        result.matchLotteryNumbers(ticketPrice, winningLotto.getNumbers(), winningLotto.getBonusNumber(), lotteryNumberMap);
    }
}
