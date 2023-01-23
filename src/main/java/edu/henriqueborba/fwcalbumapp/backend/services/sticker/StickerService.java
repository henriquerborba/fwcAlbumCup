package edu.henriqueborba.fwcalbumapp.backend.services.sticker;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.core.dtos.sticker.StickerRequest;
import edu.henriqueborba.fwcalbumapp.core.models.Sticker;
import edu.henriqueborba.fwcalbumapp.backend.repositories.StickerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StickerService {

    private final StickerRepository repository;

    public List<Sticker> getAllSticker() {
        return (List<Sticker>) repository.findAll();
    }

    public Sticker createSticker(StickerRequest sticker) {
        final Sticker newSticker = Sticker.builder()
                .name(sticker.getName())
                .number(sticker.getNumber())
                .code(sticker.getCode())
                .build();

        return repository.save(newSticker);
    }

    public Sticker getStickerById(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new BusinessException("Figurinha não encontrada", HttpStatus.NOT_FOUND)
        );
    }

    public Sticker updateSticker(Long id, StickerRequest sticker) {
        final Sticker stickerToUpdate = repository.findById(id).orElseThrow();

        stickerToUpdate.setName(sticker.getName());
        stickerToUpdate.setNumber(sticker.getNumber());
        stickerToUpdate.setCode(sticker.getCode());

        return repository.save(stickerToUpdate);
    }

    public List<Sticker> searchStickerByCodeAndNumber(String stickerCode, Long stickerNumber) {
        return repository.findAllByCodeAndNumber(stickerCode, stickerNumber);
    }
}
