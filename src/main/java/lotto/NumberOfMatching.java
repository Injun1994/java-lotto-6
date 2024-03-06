package lotto;

public enum NumberOfMatching {

    MATCHING_0_NUMBERS(0, false, 0),
    MATCHING_1_NUMBERS(1, false, 0),
    MATCHING_2_NUMBERS(2, false, 0),
    MATCHING_3_NUMBERS(3, false, 5_000),
    MATCHING_4_NUMBERS(4, false, 50_000),
    MATCHING_5_NUMBERS(5, false, 1_500_000),
    MATCHING_5_NUMBERS_WITH_BONUS_NUMBER(5, true, 30_000_000),
    MATCHING_6_NUMBERS(6, false, 2_000_000_000);

    private final int numberOfMatchingLotteryNumbers;
    private final boolean resultOfBonusNumber;
    private final long matchPayout;

    NumberOfMatching(int numberOfMatchingLotteryNumbers, boolean resultOfBonusNumber, long matchPayout) {
        this.numberOfMatchingLotteryNumbers = numberOfMatchingLotteryNumbers;
        this.resultOfBonusNumber = resultOfBonusNumber;
        this.matchPayout = matchPayout;
    }

    public boolean isMatch(int numberOfMatchingLotteryNumbers, boolean resultOfBonusNumber) {
        return this.numberOfMatchingLotteryNumbers == numberOfMatchingLotteryNumbers && this.resultOfBonusNumber == resultOfBonusNumber;
    }

    public long getMatchPayOut() {
        return matchPayout;
    }
}
