package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @ParameterizedTest
    @CsvSource({"3000, 5000, 60"})
    public void 확률_계산_테스트(int ticketPrice, int matchPayout, int expectedResult) {
        //given

        //when
        String result = new Result().getROI(ticketPrice, matchPayout);
        //then
        assertEquals(result, expectedResult);
    }
}
