package lotto;

public class Print {

    public static final String UNIT_FOR_MATCH = "개";
    public static final String INSERT_MONEY = "구입금액을 입력해주세요.";
    public static final String INSERT_MONEY_ERROR = "[ERROR] 금액은 1000의 배수여야 합니다.";
    public static final String NUMBER_OF_PURCHASE = "개를 구매했습니다.";
    public static final String INPUT_LOTTERY_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_LOTTERY_NUMBERS_ERROR = "[ERROR] 1~45 사이의 각기 다른 숫자를 6개 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String INPUT_BONU_NUMBERS_ERROR = "[ERROR] 1~45 사이의 숫자 1개를 입력해 주세요.";
    public static final String LOTTERY_STATISTICS = "당첨 통계";
    public static final String MATCHING_3_NUMBERS = "3개 일치 (5,000원) - ";
    public static final String MATCHING_4_NUMBERS = "4개 일치 (50,000원) - ";
    public static final String MATCHING_5_NUMBERS = "5개 일치 (1,500,000원) - ";
    public static final String MATCHING_5_NUMBERS_WITH_BONUS = "5개 일치 (30,000,000원) - ";
    public static final String MATCHING_6_NUMBERS = "6개 일치, 보너스 볼 일치 (2,000,000,000원) - ";
    public static final String TOTAL_RATE_OF_RETURN = "총 수익율은 ";

    public void printMatchingResult(int numberOfMatching3Numbers, int numberOfMatching4Numbers, int numberOfMatching5Numbers, int numberOfMatching5NumbersWithBonus, int numberOfMatching6Numbers) {
        System.out.println("\n" + LOTTERY_STATISTICS);
        System.out.println("---");
        System.out.println(MATCHING_3_NUMBERS + numberOfMatching3Numbers + UNIT_FOR_MATCH);
        System.out.println(MATCHING_4_NUMBERS + numberOfMatching4Numbers + UNIT_FOR_MATCH);
        System.out.println(MATCHING_5_NUMBERS + numberOfMatching5Numbers + UNIT_FOR_MATCH);
        System.out.println(MATCHING_5_NUMBERS_WITH_BONUS + numberOfMatching5NumbersWithBonus + UNIT_FOR_MATCH);
        System.out.println(MATCHING_6_NUMBERS + numberOfMatching6Numbers + UNIT_FOR_MATCH);
    }
}
