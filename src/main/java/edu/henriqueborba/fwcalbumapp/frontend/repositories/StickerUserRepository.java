package edu.henriqueborba.fwcalbumapp.frontend.repositories;

import edu.henriqueborba.fwcalbumapp.core.models.Sticker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "StickerUser", url = "http://localhost:8080/api/user/sticker")
public interface StickerUserRepository {

    @GetMapping("/coutries")
    List<Sticker> getStickerOrderByCountry();


}
