package qk.myGroup.gifThrower;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import qk.myGroup.gifThrower.ClientsImpl.Service;
import qk.myGroup.gifThrower.client.CurrencyClient;
import qk.myGroup.gifThrower.client.GifClient;
import qk.myGroup.gifThrower.responseModel.Currency.CurrencyResponse;
import qk.myGroup.gifThrower.responseModel.GIF.Gif;


@Controller
public class MainController {

    @Value("${giphyKey}")
    String giphyKey;
    @Value("${ratesKey}")
    String ratesKey;


    @Autowired
    private GifClient gifClient;
    @Autowired
    private CurrencyClient currencyClient;

    private Service service = new Service();


    @GetMapping()
    public String getGif( Model model) {
       Gif gif = new Gif();
       CurrencyResponse last = currencyClient.lastCurrency(ratesKey);
       String yesterdayDay = service.getYesterdayDay(last.getTimestamp());
       CurrencyResponse previous = currencyClient.yesterdayCurrency(yesterdayDay, ratesKey);
       Double lastRubRate= last.getRates().getRub();
       Double previousRubRate = previous.getRates().getRub();

       gif = gifClient.getMyGif(giphyKey,  service.getDiff(lastRubRate, previousRubRate));


     model.addAttribute("result", gif.getData().getImages().getOriginal().getUrl());

        return "home";
    }
}
