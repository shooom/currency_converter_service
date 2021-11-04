package nosto.homework.converterApi.dto;

public class ConverterDto {
    public String source;
    public String target;
    public String rate;
    public String amountSource;
    public String amountResult;

    public ConverterDto(String source, String target, String amount) {
        this.source = source;
        this.target = target;
        this.rate = "1";
        this.amountSource = amount;
        this.amountResult = amount;
    }

    public ConverterDto(String source, String target, String rate, String amountSource, String amountResult) {
        this.source = source;
        this.target = target;
        this.rate = rate;
        this.amountSource = amountSource;
        this.amountResult = amountResult;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public void setAmountSource(String amountSource) {
        this.amountSource = amountSource;
    }

    public void setAmountResult(String amountResult) {
        this.amountResult = amountResult;
    }
}
