package edu.henriqueborba.fwcalbumapp.backend.repositories;

import edu.henriqueborba.fwcalbumapp.core.models.StickerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StickerUserRepository extends JpaRepository<StickerUser, Long> {


    @Query("SELECT su FROM StickerUser su WHERE su.id.user.id = :userId")
    List<StickerUser> findAllByUserId(Long userId);

    @Query(value = "SELECT su FROM StickerUser su WHERE su.id.user.id = :userId AND su.amount > 1")
    List<StickerUser> findAllDuplicateByUserId(Long userId);
}

