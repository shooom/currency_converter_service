package nosto.homework.converterApi;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import nosto.homework.common.InitParams;
import nosto.homework.converterApi.contorllers.ConverterController;
import nosto.homework.converterApi.exceptions.FreePlanBaseCurrencyException;
import nosto.homework.exchangeRateClient.exceptinos.ExRateClientException;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class ApiServer {

    public static void startServer() {
        var app = Javalin.create().start(InitParams.CONVERTER_APP_PORT);

        app.routes(() -> {
            path("converter", () -> {
                get(ConverterController.sayHello);
                path("convert", () -> {
                    get(ConverterController.convert);
                });
            });
        });

        app.exception(FreePlanBaseCurrencyException.class, (e, ctx) -> {
            ctx.status(HttpCode.BAD_REQUEST);
            ctx.result(e.getMessage());
        }).exception(ExRateClientException.class, (e, ctx) -> {
           ctx.status(HttpCode.BAD_REQUEST);
           ctx.result(e.getMessage());
        });
    }
}
