package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    public static final int LOTTERY_START_NUMBER = 1;
    public static final int LOTTERY_END_NUMBER = 45;
    public static final int LOTTERY_NUMBER_IN_A_SET = 6;

    public List<Integer> getLotteryNumbers() {
        List<Integer> lotteryNumberList = new ArrayList<>();
        while (lotteryNumberList.size() < LOTTERY_NUMBER_IN_A_SET) {
            int lotteryNumber = Randoms.pickNumberInRange(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER);
            if (!lotteryNumberList.contains(lotteryNumber)) {
                lotteryNumberList.add(lotteryNumber);
            }
        }
        return lotteryNumberList;
    }

    public int getBonusNumber() {
        return Randoms.pickNumberInRange(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER);
    }

    public Map<List<Integer>, Integer> getLotteryNumbersAndBonusNumber(int numberOfTicket) {
        Map<List<Integer>, Integer> lotteryNumberMap = new HashMap<>();
        for (int i = 0; i < numberOfTicket; i++) {
            Lotto lotto = new Lotto();

            List<Integer> lotteryNumberList = lotto.getLotteryNumbers();
            Collections.sort(lotteryNumberList);
            System.out.println(lotteryNumberList);

            lotteryNumberMap.put(lotteryNumberList, lotto.getBonusNumber());
        }
        return lotteryNumberMap;
    }
}
