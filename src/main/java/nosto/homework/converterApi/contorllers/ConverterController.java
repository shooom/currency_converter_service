package nosto.homework.converterApi.contorllers;

import io.javalin.http.Handler;
import nosto.homework.converterApi.services.ConverterService;

public class ConverterController {

    public static final ConverterService converterService = new ConverterService();

    public static Handler sayHello = ctx -> {
        ctx.result("Hello, my friend!");
    };

    public static Handler convert = ctx -> {
        String from = ctx
                .queryParamAsClass("source", String.class)
                .check(param -> param != null && !param.equals(""), "[source] param value undefined")
                .get();
        String to = ctx
                .queryParamAsClass("target", String.class)
                .check(param -> param != null && !param.equals(""), "[target] param value undefined")
                .get();
        String amount = ctx
                .queryParamAsClass("monetary", String.class)
                .check(param -> param.matches("^\\d+$"), "[monetary] param must contains only digits")
                .get();

        ctx.json(converterService.convert(from, to, amount));
    };
}
