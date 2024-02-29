package lotto;

import java.text.DecimalFormat;
import java.util.*;

public class Application {

    private int numberOfMatching3Numbers = 0;
    private int numberOfMatching4Numbers = 0;
    private int numberOfMatching5Numbers = 0;
    private int numberOfMatching5NumbersWithBonus = 0;
    private int numberOfMatching6Numbers = 0;
    private boolean resultOfBonusNumber = false;
    private int matchPayout = 0;

    public static void main(String[] args) {

        Application application = new Application();
        Input input = new Input();
        Ticket ticket = new Ticket();
        Print print = new Print();

        int ticketPrice = input.inputAmount();
        int numberOfTicket = ticket.getTicket(ticketPrice);
        System.out.println("\n" + numberOfTicket + Print.NUMBER_OF_PURCHASE);

        Map<List<Integer>, Integer> lotteryNumberMap = new Lotto().getLotteryNumbersAndBonusNumber(numberOfTicket);
        WinningLotto winningLotto = new WinningLotto(input.inputLotteryNumbers(), input.inputBonusNumber());

        application.matchLotteryNumbers(winningLotto.getNumbers(), winningLotto.getBonusNumber(), lotteryNumberMap);
        print.printMatchingResult(application.numberOfMatching3Numbers, application.numberOfMatching4Numbers, application.numberOfMatching5Numbers, application.numberOfMatching5NumbersWithBonus, application.numberOfMatching6Numbers);
        System.out.println(Print.TOTAL_RATE_OF_RETURN + application.getROI(ticketPrice, application.matchPayout) + "% 입니다.");
    }

    public void matchLotteryNumbers(List<Integer> winningLotteryNumberList, int winningBonusNumber, Map<List<Integer>, Integer> lotteryNumberMap) {
        for (Map.Entry<List<Integer>, Integer> lotteryNumberEntry : lotteryNumberMap.entrySet()) {
            List<Integer> lotteryNumberList = lotteryNumberEntry.getKey();
            int bonusNumber = lotteryNumberEntry.getValue();

            int numberOfMatchingLotteryNumbers = (int) winningLotteryNumberList.stream()
                    .filter(lotteryNumberList::contains)
                    .count();

            boolean resultOfBonusNumber = winningBonusNumber == bonusNumber;

            getTotalPrize(numberOfMatchingLotteryNumbers, resultOfBonusNumber);
        }
    }

    public void getTotalPrize(int numberOfMatchingLotteryNumbers, boolean resultOfBonusNumber) {
        switch (numberOfMatchingLotteryNumbers) {
            case 3:
                numberOfMatching3Numbers++;
                matchPayout += Print.PRIZE_FOR_MATCHING_3_NUMBERS;
                break;
            case 4:
                numberOfMatching4Numbers++;
                matchPayout += Print.PRIZE_FOR_MATCHING_4_NUMBERS;
                break;
            case 5:
                if(resultOfBonusNumber) {
                    numberOfMatching5NumbersWithBonus++;
                    matchPayout += Print.PRIZE_FOR_MATCHING_5_NUMBERS_WITH_BONUS_NUMBER;
                } else {
                    numberOfMatching5Numbers++;
                    matchPayout += Print.PRIZE_FOR_MATCHING_5_NUMBERS;
                }
                break;
            case 6:
                numberOfMatching6Numbers++;
                matchPayout += Print.PRIZE_FOR_MATCHING_6_NUMBERS;
                break;
        }
    }

    public String getROI(int ticketPrice, int matchPayout) {
        double returnOnInvestment = matchPayout / ticketPrice * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(returnOnInvestment);
    }
}
