package nosto.homework.exchangeRateClient.dto;

public class ExRateBase {
    public Boolean success;
    public ErrorBody error;

    public static class ErrorBody {
        String code;
        String info;

        @Override
        public String toString() {
            return "Exchange rate API error "
                    + code + ": \'"
                    + info + "\'";
        }
    }
}
