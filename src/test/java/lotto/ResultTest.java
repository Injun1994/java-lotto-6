package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @DisplayName("3장 구매하고, 결과가 3개가 일치할 때")
    @Test
    public void 확률_계산_테스트() {
        //given
        int ticketPrice = 3000;
        int matchPayout = 5000;
        //when
        String result = new Result().getROI(ticketPrice, matchPayout);
        //then
        assertEquals(result, "60");
    }
}