package nosto.homework.converterApi.exceptions;

public class FreePlanBaseCurrencyException extends RuntimeException {

    public FreePlanBaseCurrencyException(String currencyTag) {
        super(String.format("%s doesn't support for Free plan on Exchange Rate API", currencyTag));
    }
}
