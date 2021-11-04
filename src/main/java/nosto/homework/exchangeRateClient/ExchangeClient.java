package nosto.homework.exchangeRateClient;

import nosto.homework.exchangeRateClient.dto.ExRateLatest;
import nosto.homework.exchangeRateClient.dto.RateContainer;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ExchangeClient {

    private final String EXCHANGE_URL = "http://api.exchangeratesapi.io/v1/";
    private final String ACCESS_KEY = "c7b28097c5d0de6f50e5ed1531b0b877";
    private final String ACCESS_KEY_NAME = "access_key";

    private final MessageParser parser = new MessageParser();
    private final OkHttpClient client = new OkHttpClient();

    public RateContainer getLatestRate(String from, String to) throws IOException {
        RateContainer result;
        var url = base()
                .addEncodedPathSegment("latest")
                .addEncodedQueryParameter("base", from)
                .addEncodedQueryParameter("symbols", to)
                .build();
        var request = new Request.Builder().url(url).build();

        try(Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code" + response);
            }

            ExRateLatest latest = parser.parseLatest(response.body());

            System.out.println(latest);
            result = new RateContainer(from, to, latest.getRates().get(to));
        }
            return result;
    }

    public void loadSymbols() throws Exception {
        var url = base()
                .addEncodedPathSegment("symbols")
                .build();
        var request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()){
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code" + response);
            }
            System.out.println(parser.parseSymbols(response.body()).toString());
        }
    }

    private HttpUrl.Builder base() {
        return HttpUrl.parse(EXCHANGE_URL).newBuilder().addEncodedQueryParameter(ACCESS_KEY_NAME, ACCESS_KEY);
    }
}
