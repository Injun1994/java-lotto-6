package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final String INPUT_NUMBERS_SEPARATOR = ",";

    public int inputAmount() {
        System.out.println(Print.INSERT_MONEY);
        int amount = 0;
        try {
            String input = Console.readLine();
            amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                return inputAmount();
            }
        } catch (NumberFormatException numberFormatException) {
            numberFormatException.getStackTrace();
            System.out.println(Print.INSERT_MONEY_ERROR);
            return inputAmount();
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.getStackTrace();
            System.out.println(Print.INSERT_MONEY_ERROR);
            return inputAmount();
        }
        return amount;
    }

    public List<Integer> inputLotteryNumbers() {
        System.out.println("\n" + Print.INPUT_LOTTERY_NUMBERS);
        return validateLotteryNumbers(Console.readLine().split(INPUT_NUMBERS_SEPARATOR));
    }

    public int inputBonusNumber() {
        System.out.println("\n" + Print.INPUT_BONUS_NUMBER);
        try {
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
            return inputBonusNumber();
        }
    }

    public List<Integer> validateLotteryNumbers(String[] lotteryNumbers) {
        boolean beInRange = true;
        List<Integer> lotteryNumberList = new ArrayList<>();
        try {
            if (!isDuplicate(lotteryNumbers) && lotteryNumbers.length == Lotto.LOTTERY_NUMBER_IN_A_SET) {
                for (String lotteryNumber : lotteryNumbers) {
                    if (Integer.parseInt(lotteryNumber) < Lotto.LOTTERY_START_NUMBER || Lotto.LOTTERY_END_NUMBER < Integer.parseInt(lotteryNumber)) {
                        beInRange = false;
                    }
                }
                if (beInRange) {
                    lotteryNumberList = convertToList(lotteryNumbers);
                }
            } else {
                inputLotteryNumbers();
            }
        } catch (IllegalArgumentException e) {
            e.getStackTrace();
            System.out.println(Print.INPUT_LOTTERY_NUMBERS_ERROR);
            inputLotteryNumbers();
        }
        return lotteryNumberList;
    }

    public List<Integer> convertToList(String[] lotteryNumbers) {
        return Arrays.stream(lotteryNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean isDuplicate(String[] lotteryNumbers) {
        HashSet<String> lotteryNumbersSet = new HashSet<>(Arrays.asList(lotteryNumbers));
        return lotteryNumbersSet.size() < lotteryNumbers.length;
    }

    public void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < Lotto.LOTTERY_START_NUMBER || Lotto.LOTTERY_END_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(Print.INPUT_BONUS_NUMBERS_ERROR);
        }
    }
}
