package edu.henriqueborba.fwcalbumapp.services.sticker;

import edu.henriqueborba.fwcalbumapp.dtos.sticker.StickerRequest;
import edu.henriqueborba.fwcalbumapp.models.Sticker;
import edu.henriqueborba.fwcalbumapp.repository.StickerRepository;
import lombok.RequiredArgsConstructor;
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
}
