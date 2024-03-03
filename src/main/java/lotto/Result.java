package lotto;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class Result {

    public static final int PRIZE_FOR_MATCHING_3_NUMBERS = 5000;
    public static final int PRIZE_FOR_MATCHING_4_NUMBERS = 50000;
    public static final int PRIZE_FOR_MATCHING_5_NUMBERS = 1500000;
    public static final int PRIZE_FOR_MATCHING_5_NUMBERS_WITH_BONUS_NUMBER = 30000000;
    public static final int PRIZE_FOR_MATCHING_6_NUMBERS = 2000000000;
    private int numberOfMatching3Numbers = 0;
    private int numberOfMatching4Numbers = 0;
    private int numberOfMatching5Numbers = 0;
    private int numberOfMatching5NumbersWithBonus = 0;
    private int numberOfMatching6Numbers = 0;
    private int matchPayout = 0;

    public void matchLotteryNumbers(int ticketPrice, List<Integer> winningLotteryNumberList, int winningBonusNumber, Map<List<Integer>, Integer> lotteryNumberMap) {
        for (Map.Entry<List<Integer>, Integer> lotteryNumberEntry : lotteryNumberMap.entrySet()) {
            List<Integer> lotteryNumberList = lotteryNumberEntry.getKey();
            int bonusNumber = lotteryNumberEntry.getValue();

            int numberOfMatchingLotteryNumbers = (int) winningLotteryNumberList.stream()
                    .filter(lotteryNumberList::contains)
                    .count();

            boolean resultOfBonusNumber = winningBonusNumber == bonusNumber;

            getTotalPrize(numberOfMatchingLotteryNumbers, resultOfBonusNumber);
        }
        new Print().printMatchingResult(numberOfMatching3Numbers, numberOfMatching4Numbers, numberOfMatching5Numbers, numberOfMatching5NumbersWithBonus, numberOfMatching6Numbers);
        System.out.println(Print.TOTAL_RATE_OF_RETURN + getROI(ticketPrice, matchPayout) + "% 입니다.");
    }

    public void getTotalPrize(int numberOfMatchingLotteryNumbers, boolean resultOfBonusNumber) {
        NumberOfMatching numberOfMatching = null;

        switch (numberOfMatchingLotteryNumbers) {
            case 3:
                numberOfMatching3Numbers++;
                numberOfMatching = NumberOfMatching.MATCHING_3_NUMBERS;
                break;
            case 4:
                numberOfMatching4Numbers++;
                numberOfMatching = NumberOfMatching.MATCHING_4_NUMBERS;
                break;
            case 5:
                if (resultOfBonusNumber) {
                    numberOfMatching5NumbersWithBonus++;
                    numberOfMatching = NumberOfMatching.MATCHING_5_NUMBERS_WITH_BONUS_NUMBER;
                } else {
                    numberOfMatching5Numbers++;
                    numberOfMatching = NumberOfMatching.MATCHING_5_NUMBERS;
                }
                break;
            case 6:
                numberOfMatching6Numbers++;
                numberOfMatching = NumberOfMatching.MATCHING_6_NUMBERS;
                break;
        }

        if (numberOfMatching != null) {
            matchPayout += numberOfMatching.getMatchPayout();
        }
    }

    public String getROI(int ticketPrice, int matchPayout) {
        double returnOnInvestment = (double) ticketPrice / matchPayout * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return decimalFormat.format(returnOnInvestment);
    }
}
