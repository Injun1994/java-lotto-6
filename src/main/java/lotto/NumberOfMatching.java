package lotto;

public enum NumberOfMatching {

    MATCHING_3_NUMBERS(Result.PRIZE_FOR_MATCHING_3_NUMBERS),
    MATCHING_4_NUMBERS(Result.PRIZE_FOR_MATCHING_4_NUMBERS),
    MATCHING_5_NUMBERS(Result.PRIZE_FOR_MATCHING_5_NUMBERS),
    MATCHING_5_NUMBERS_WITH_BONUS_NUMBER(Result.PRIZE_FOR_MATCHING_5_NUMBERS_WITH_BONUS_NUMBER),
    MATCHING_6_NUMBERS(Result.PRIZE_FOR_MATCHING_6_NUMBERS);

    private final int matchPayout;

    NumberOfMatching(int matchPayout) {
        this.matchPayout = matchPayout;
    }

    public int getMatchPayout() {
        return matchPayout;
    }
}
