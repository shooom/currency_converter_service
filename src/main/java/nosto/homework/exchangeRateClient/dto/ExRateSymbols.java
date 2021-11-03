package nosto.homework.exchangeRateClient.dto;

import java.util.Map;

public class ExRateSymbols extends ExRateBase {
    Map<String, String> symbols;

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        for(String key : symbols.keySet()) {
            buf.append(key + ": " + symbols.get(key) + "\n");
        }
        return buf.toString();
    }
}
