package lotto;

import java.text.DecimalFormat;
import java.util.*;

public class Result {

    private static final String ROI_DECIMAL_FORMAT = "#.##";

    public void matchLotteryNumbers(int ticketPrice, List<Integer> winningLotteryNumberList, int winningBonusNumber, Map<List<Integer>, Integer> lotteryNumberMap) {
        List<NumberOfMatching> numberOfMatchingList = new ArrayList<>();

        for (Map.Entry<List<Integer>, Integer> lotteryNumberSet : lotteryNumberMap.entrySet()) {
            List<Integer> lotteryNumberList = lotteryNumberSet.getKey();
            int bonusNumber = lotteryNumberSet.getValue();

            int numberOfMatchingLotteryNumbers = (int) winningLotteryNumberList.stream()
                    .filter(lotteryNumberList::contains)
                    .count();
            boolean resultOfBonusNumber = winningBonusNumber == bonusNumber;

            Optional<NumberOfMatching> numberOfMatching = Arrays.stream(NumberOfMatching.values())
                    .filter(e -> e.isMatch(numberOfMatchingLotteryNumbers, resultOfBonusNumber))
                    .findFirst();
            numberOfMatchingList.add(numberOfMatching.get());
        }
        new Print().printMatchingResult(numberOfMatchingList);
        long matchPayout = numberOfMatchingList.stream()
                .mapToLong(NumberOfMatching::getMatchPayOut)
                .sum();
        System.out.println(Print.TOTAL_RATE_OF_RETURN + getROI(ticketPrice, matchPayout) + "% 입니다.");
    }

    public String getROI(int ticketPrice, long matchPayout) {
        double returnOnInvestment = (double) matchPayout / ticketPrice * 100;
        DecimalFormat decimalFormat = new DecimalFormat(ROI_DECIMAL_FORMAT);
        return decimalFormat.format(returnOnInvestment);
    }
}
