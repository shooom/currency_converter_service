package nosto.homework.converterApi;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;
import nosto.homework.converterApi.contorllers.ConverterController;
import nosto.homework.converterApi.exceptions.FreePlanBaseCurrencyException;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;

public class ApiServer {

    public static void startServer() {
        Javalin app = Javalin.create().start(8090);

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
        });
    }
}
