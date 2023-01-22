package edu.henriqueborba.fwcalbumapp.repository;

import edu.henriqueborba.fwcalbumapp.models.Sticker;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StickerRepository extends JpaRepository<Sticker, Long> {

    List<Sticker> findAllByCodeAndNumber(String stickerCode, Long stickerNumber);

    List<Sticker> findAllByOrderByCodeAscNumberAsc();

}

