package edu.henriqueborba.fwcalbumapp.controllers.sticker;

import edu.henriqueborba.fwcalbumapp.dtos.sticker.StickerRequest;
import edu.henriqueborba.fwcalbumapp.models.Sticker;
import edu.henriqueborba.fwcalbumapp.services.sticker.StickerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sticker")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Sticker", description = "Cadastro e visualização das figurinhas")
public class StickerController {

    final StickerService service;

    @Operation(summary = "Listar todas as figurinhas do sistema.")
    @GetMapping
    public ResponseEntity<List<Sticker>> getAllSticker() {
        return ResponseEntity.ok(service.getAllSticker());
    }

    @Operation(summary = "Adicionar figurinhas ao sistema")
    @PostMapping
    public ResponseEntity<Sticker> createSticker(@Valid @RequestBody StickerRequest sticker) {
        return ResponseEntity.ok(service.createSticker(sticker));
    }

    @Operation(summary = "detalhe de uma figurinha especifica")
    @GetMapping("/{id}")
    public ResponseEntity<Sticker> getStickerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStickerById(id));
    }

    @Operation(summary = "Atualizar uma figurinha especifica")
    @PostMapping("/{id}")
    public ResponseEntity<Sticker> updateSticker(@PathVariable Long id,@Valid @RequestBody StickerRequest sticker) {
        return ResponseEntity.ok(service.updateSticker(id, sticker));
    }

    @Operation(summary = "Pesquisa figurinha por Codigo + número")
    @GetMapping("/search")
    public ResponseEntity<List<Sticker>> searchStickerByCodeAndNumber(
            @Parameter(description = "Código do país", required = false) @RequestParam(value = "sticker_code", required = false) String stickerCode,
            @Parameter(description = "Número da figurinha", required = false) @RequestParam(value = "sticker_number", required = false) Long stickerNumber) {
        return ResponseEntity.ok(service.searchStickerByCodeAndNumber(stickerCode, stickerNumber));
    }

}
