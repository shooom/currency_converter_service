package nosto.homework.exchangeRateClient.dto;

import java.math.BigDecimal;

public class RateContainer {
    private String source;
    private String target;
    private BigDecimal rate;

    public RateContainer(String source, String target, String rate) {
        this.source = source;
        this.target = target;
        this.rate = new BigDecimal(rate);
    }

    public String getSource() {
        return source;
    }

    public String getTarget() {
        return target;
    }

    public BigDecimal getRate() {
        return rate;
    }
}
