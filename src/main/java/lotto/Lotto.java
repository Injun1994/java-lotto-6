package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {

    public List<Integer> getLotteryNumbers() {
        List<Integer> lotteryNumberList = new ArrayList<>();
        while (lotteryNumberList.size() < Print.LOTTERY_NUMBER_IN_A_SET) {
            int lottertNumber = Randoms.pickNumberInRange(1, 45);
            if (!lotteryNumberList.contains(lottertNumber)) {
                lotteryNumberList.add(lottertNumber);
            }
        }
        return lotteryNumberList;
    }

    public int getBonusNumber() {
        return Randoms.pickNumberInRange(1, 45);
    }

    public Map<List<Integer>, Integer> getLotteryNumbersAndBonusNumber(int numberOfTicket) {
        Map<List<Integer>, Integer> lotteryNumberMap = new HashMap<>();
        for (int i = 0; i < numberOfTicket; i++) {
            Lotto lotto = new Lotto();

            List<Integer> lotteryNumberList = lotto.getLotteryNumbers();
            Collections.sort(lotteryNumberList);
            System.out.println(lotteryNumberList.toString());

            lotteryNumberMap.put(lotteryNumberList, lotto.getBonusNumber());
        }
        return lotteryNumberMap;
    }
}
