package nosto.homework.converterApi.services;

import nosto.homework.monetary.MonetaryService;
import nosto.homework.converterApi.dto.ConverterDto;
import nosto.homework.converterApi.exceptions.FreePlanBaseCurrencyException;
import nosto.homework.exchangeRateClient.ExchangeClient;
import nosto.homework.exchangeRateClient.dto.RateContainer;

import java.io.IOException;
import java.math.BigDecimal;

import static nosto.homework.common.ConverterConstants.FREE_PLAN_BASE_CURRENCY;

public class ConverterService {
    private static final MonetaryService monetaryService = new MonetaryService();
    private static final ExchangeClient client = new ExchangeClient();

    public ConverterDto convert(String from, String to, String amount) {
        ConverterDto result = new ConverterDto(from, to, amount);

        if (from.equalsIgnoreCase(to)) {
            result.setRate("1");
            result.setAmountResult(amount);
            return result;
        }

        if (!from.equalsIgnoreCase(FREE_PLAN_BASE_CURRENCY)) {
            throw new FreePlanBaseCurrencyException(from);
        }

        try {
            RateContainer rateObj = client.getLatestRate(from, to);
            BigDecimal convertedAmount = monetaryService.convert(amount, rateObj.getRate().toString());
            return new ConverterDto(from, to, rateObj.getRate().toString(), amount, convertedAmount.toString());
        } catch (IOException ex) {
            System.out.println("Unexpected error: " + ex.getMessage());
        }
        return result;
    }
}
