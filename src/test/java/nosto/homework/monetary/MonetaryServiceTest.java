package nosto.homework.monetary;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MonetaryServiceTest {

    private MonetaryService service;

    @Before
    public void init() {
        service = new MonetaryService();
    }

    @Test
    public void convert_success() {

        String rate = "83.06";
        String amount = "100";
        BigDecimal expected = new BigDecimal("8306.0000");

        assertEquals(expected, service.convert(amount, rate));
    }
}