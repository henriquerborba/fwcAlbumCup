package edu.henriqueborba.fwcalbumapp.core.dtos.sticker_user;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StickerUserRequest {

    @NotNull
    Long idSticker;

    @NotNull
    int amount;

}
