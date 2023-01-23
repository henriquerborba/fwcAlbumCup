package edu.henriqueborba.fwcalbumapp.backend.repositories;

import edu.henriqueborba.fwcalbumapp.core.models.Sticker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<Sticker, Long> {

    List<Sticker> findAllByCodeAndNumber(String stickerCode, Long stickerNumber);

    List<Sticker> findAllByOrderByCodeAscNumberAsc();

}

