package edu.henriqueborba.fwcalbumapp.controllers.sticker_user;

import edu.henriqueborba.fwcalbumapp.dtos.sticker_user.StickerUserRequest;
import edu.henriqueborba.fwcalbumapp.models.Sticker;
import edu.henriqueborba.fwcalbumapp.models.StickerUser;
import edu.henriqueborba.fwcalbumapp.services.sticker_user.StickerUserService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user/sticker")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Sticker User", description = "Cadastro e visualização das figurinhas do usuário")
public class StickerUserController {

    private final StickerUserService service;
    
    @Operation(summary = "Atualizar a quantidade de figurinha escolhida de um usuário")
    @PutMapping
    public ResponseEntity<Object> updateStickerUser(@Valid @RequestBody StickerUserRequest stickerUserRequest) {
        service.updateStickerUser(stickerUserRequest);
        return new ResponseEntity<>("Quantidade atualizada com sucesso", HttpStatus.OK);
    }

    @Operation(summary = "Mostrar o album completo ordenado por país")
    @GetMapping("/countries")
    public ResponseEntity<List<Sticker>> showAlbumByCountry() {
        return new ResponseEntity<>(service.showAlbumByCountry(), HttpStatus.OK);
    }

    @Operation(summary = "Pegar as figurinhas do usuário")
    @GetMapping()
    public ResponseEntity<List<StickerUser>> showStickersUser(
            @Parameter(description = "Mostrar somente duplicados", name = "duplicate") @RequestParam boolean duplicate
    ) {
        return new ResponseEntity<>(service.showStickersUser(duplicate), HttpStatus.OK);
    }



}
