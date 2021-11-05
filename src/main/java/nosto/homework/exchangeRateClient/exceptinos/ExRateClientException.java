package nosto.homework.exchangeRateClient.exceptinos;

public class ExRateClientException extends RuntimeException {
    String code;
    String message;

    public ExRateClientException(String code, String message) {
        super(code + ": " + message);

        this.code = code;
        this.message = message;
    }
}
