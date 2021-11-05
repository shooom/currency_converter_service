package nosto.homework.exchangeRateClient;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import nosto.homework.exchangeRateClient.dto.ExRateLatest;
import nosto.homework.exchangeRateClient.dto.ExRateSymbols;
import okhttp3.ResponseBody;

import java.io.IOException;

public class MessageParser {
    private final Moshi moshi = new Moshi.Builder().build();
    private final JsonAdapter<ExRateSymbols> symbolsAdapter = moshi.adapter(ExRateSymbols.class);
    private final JsonAdapter<ExRateLatest> latestAdapter = moshi.adapter(ExRateLatest.class);
    public ExRateSymbols parseSymbols(ResponseBody body) throws IOException {
        return symbolsAdapter.fromJson(body.source());
    }

    public ExRateLatest parseLatest(ResponseBody body) throws IOException {
        return latestAdapter.fromJson(body.source());
    }
}
