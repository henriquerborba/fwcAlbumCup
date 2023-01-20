package edu.henriqueborba.fwcalbumapp.repository;

import edu.henriqueborba.fwcalbumapp.models.Sticker;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface StickerRepository extends CrudRepository<Sticker, Integer> {

    List<Sticker> findByCodeAndNumber(String stickerCode, Integer stickerNumber);
}

