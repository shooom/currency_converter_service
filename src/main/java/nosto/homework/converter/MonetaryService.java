package nosto.homework.converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MonetaryService {

    private final int scale = 2;

    public BigDecimal convert(String amount, String rate) {
        BigDecimal result = new BigDecimal(amount).multiply(new BigDecimal(rate));
        return result.setScale(scale, RoundingMode.HALF_EVEN);
    }
}
