package edu.henriqueborba.fwcalbumapp.dtos.sticker;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StickerRequest {
    private String name;
    private Integer number;
    @NotBlank(message = "Code is required")
    private String code;

}
