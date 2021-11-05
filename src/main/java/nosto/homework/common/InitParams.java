package nosto.homework.common;

public class InitParams {

    public static String EX_RATE_ACCESS_KEY;
    public static String EX_RATE_API_URL;
    public static int CONVERTER_APP_PORT;

    static {
        EX_RATE_API_URL = System.getenv("EX_RATE_API_URL") != null
                ? System.getenv("EX_RATE_API_URL")
                : null;
        if (EX_RATE_API_URL == null) {
            System.err.println("Add EX_RATE_API_URL param to ENV");
            System.exit(1);
        }

        EX_RATE_ACCESS_KEY = System.getenv("EX_RATE_ACCESS_KEY") != null
                ? System.getenv("EX_RATE_ACCESS_KEY")
                : null;
        if (EX_RATE_ACCESS_KEY == null) {
            System.err.println("Add EX_RATE_ACCESS_KEY to ENV");
            System.exit(1);
        }
        CONVERTER_APP_PORT = System.getenv("CONVERTER_APP_PORT") != null
                ? Integer.parseInt(System.getenv("CONVERTER_APP_PORT"))
                : 8090;
    }
}
