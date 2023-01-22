package edu.henriqueborba.fwcalbumapp.services.sticker_user;

import edu.henriqueborba.fwcalbumapp.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.dtos.sticker_user.StickerUserRequest;
import edu.henriqueborba.fwcalbumapp.models.Sticker;
import edu.henriqueborba.fwcalbumapp.models.StickerUser;
import edu.henriqueborba.fwcalbumapp.repository.StickerRepository;
import edu.henriqueborba.fwcalbumapp.repository.StickerUserRepository;
import edu.henriqueborba.fwcalbumapp.services.auth.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StickerUserService {

    private final StickerUserRepository repository;

    private final StickerRepository stickerRepository;

    private final AuthenticationService authenticationService;

    public void updateStickerUser(StickerUserRequest stickerUserRequest) {

        var user = authenticationService.me();
        var sticker = stickerRepository.findById(stickerUserRequest.getIdSticker())
                .orElseThrow(() -> new BusinessException("Esse sticker não existe", HttpStatus.UNPROCESSABLE_ENTITY));

        var stickerUser = new StickerUser(user, sticker, stickerUserRequest.getAmount());

        repository.save(stickerUser);
    }

    public List<Sticker> showAlbumByCountry() {
        return stickerRepository.findAllByOrderByCodeAscNumberAsc();
    }

    public List<StickerUser> showStickersUser(boolean duplicate) {
        var user = authenticationService.me();

        if (duplicate) {
            return repository.findAllDuplicateByUserId(user.getId());
        } else {
            return repository.findAllByUserId(user.getId());
        }

    }
}
