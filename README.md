# Java Currency converter

This is small REST-service which can convert some amount from on currency to another.

# Main dependencies

* [Javalin](https://javalin.io/) (v4.1.1) - used the rest api building
* [OkHttp](https://square.github.io/okhttp/) (4.9.2) - used as http client
* [exchangeratesapi.io](https://exchangeratesapi.io/) - used as point of truth for currency rates

#Notes about exchangeratesapi.io _free plan_

If you use the free plan on exchangeratesapi.io, you coundn't change base currency. And the base currency is **EUR**.

# How to build the app
```shell
gradle shadowJar - was builded an build/libsConverterApp-fat.jar
```

# How to run the app

At first, you need to set some environment variables:
* EX_RATE_ACCESS_KEY - your access_key for _exchangeratesapi.io_ (doesn't have default value)
* EX_RATE_API_URL - the url _exchangeratesapi.io_ (http://api.exchangeratesapi.io/v1/ as default)
* CONVERTER_APP_PORT - port of the application (8090 as default)

Then just run the next command:
```shell
    java -jar build/libs/ConverterApp-fat.jar
```

# How to check that converter works
```shell
    curl --request GET \
  --url 'http://localhost:8090/converter/convert?source=EUR&target=RUB&monetary=100'
```
The result of the request will looks like
```json
    {
      "source": "EUR",
      "target": "RUB",
      "rate": "82.668491",
      "amountSource": "100",
      "amountResult": "8266.85"
    }
```