package nosto.homework.exchangeRateClient.dto;

public class ExRateBase {
    Boolean success;
    ErrorBody error;

    public static class ErrorBody {
        String code;
        String info;
    }
}
