package edu.henriqueborba.fwcalbumapp.controllers.sticker;

import edu.henriqueborba.fwcalbumapp.dtos.sticker.StickerRequest;
import edu.henriqueborba.fwcalbumapp.models.Sticker;
import edu.henriqueborba.fwcalbumapp.services.sticker.StickerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sticker")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Sticker")
public class StickerController {

    final StickerService service;

    @Operation(summary = "Listar todas as figurinhas do sistema.")
    @GetMapping
    public ResponseEntity<List<Sticker>> getAllSticker() {
        return ResponseEntity.ok(service.getAllSticker());
    }

    @Operation(summary = "Adicionar figurinhas ao sistema")
    @PostMapping
    public ResponseEntity<Sticker> createSticker(@RequestBody StickerRequest sticker) {
        return ResponseEntity.ok(service.createSticker(sticker));
    }
}
