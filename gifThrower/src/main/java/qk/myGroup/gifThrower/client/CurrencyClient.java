package qk.myGroup.gifThrower.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.*;
import qk.myGroup.gifThrower.responseModel.Currency.CurrencyResponse;

import java.nio.file.Path;
import java.util.List;


//клиент для Курсов валют API
//url="https://openexchangerates.org/api/"
//"latest.json?app_id=722c37226f9c488e89226a95e5088b47&symbols=RUB"
@FeignClient(name="LAST-CURRENCY", url = "${ratesApi}")
public interface CurrencyClient {

    //Последнее обновление курсов валют отображает только нужный нам рубль
    @GetMapping("/latest.json")
    public CurrencyResponse lastCurrency(@RequestParam("app_id") String apiKey);

    //Курс валют на день раньше последнего обновления
    @GetMapping("/historical/{date}.json")
    public CurrencyResponse yesterdayCurrency(@PathVariable @RequestParam("date") String date,
                                                    @RequestParam("app_id") String apiKey);

}

