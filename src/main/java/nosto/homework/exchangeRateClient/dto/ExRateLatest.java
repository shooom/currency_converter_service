package nosto.homework.exchangeRateClient.dto;

import java.util.Map;

public class ExRateLatest extends ExRateBase {
    String timestamp;
    String base;
    String date;
    Map<String, String> rates;

    public Map<String, String> getRates() {
        return this.rates;
    }
}
