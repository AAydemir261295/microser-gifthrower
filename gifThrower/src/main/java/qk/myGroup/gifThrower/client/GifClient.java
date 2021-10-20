package qk.myGroup.gifThrower.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import qk.myGroup.gifThrower.responseModel.GIF.Gif;

//Клиент для гиф Api
@FeignClient(name="GIF-CLIENT", url="${giphyApi}")
public interface GifClient {

    @GetMapping()
    public Gif getMyGif(@RequestParam("api_key") String apikey,
                        @RequestParam("tag") String tag);
}
