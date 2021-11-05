package nosto.homework.exchangeRateClient.dto;

public class ExRateBase {
    public Boolean success;
    public ErrorBody error;

    public static class ErrorBody {
        public String code;
        public String message;

        @Override
        public String toString() {
            return code + ": \'" + message + "\'";
        }
    }
}
