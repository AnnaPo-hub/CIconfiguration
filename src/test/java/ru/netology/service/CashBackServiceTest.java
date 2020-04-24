package ru.netology.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CashBackServiceTest {
    CashBackService cashBackService = new CashBackService();

@ParameterizedTest
@CsvSource({"900, 100", "1000,0", "2000,0"})
void shouldCheckRemain( int amount, int expected){
    int actual = cashBackService.remain(amount);
    assertEquals(expected, actual);
}
    @Test
    public void shouldReturn100IfAmountIs900() {
        int actual = cashBackService.remain(900);
        assertEquals(100, actual);
    }

    @Test
    public void shouldReturnZeroIfAmountIsEqualToBoundary() {
        int actual = cashBackService.remain(1000);
        assertEquals(0, actual);
    }

    @Test
    public void shouldThrowExceptionIfAmountLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> cashBackService.remain(-1));
    }
}
