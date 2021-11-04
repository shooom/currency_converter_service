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

    @Override
    public String toString() {
        var buf = new StringBuffer();
        buf.append("Convert from " + base + ": ");

        for(String key : rates.keySet()) {
            buf.append("\n to " + key + " equals " + rates.get(key));
        }
        return buf.toString();
    }
}
