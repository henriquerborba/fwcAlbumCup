package edu.henriqueborba.fwcalbumapp.controllers.auth;

import edu.henriqueborba.fwcalbumapp.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.dtos.auth.AuthenticationResponse;
import edu.henriqueborba.fwcalbumapp.dtos.auth.RegisterRequest;
import edu.henriqueborba.fwcalbumapp.models.User;
import edu.henriqueborba.fwcalbumapp.services.auth.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
@Tag(name = "Auth")
public class AuthController {

    private final AuthenticationService service;

    @Operation(summary = "Registrar usuário no sistema")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Validated @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @Operation(summary = "Fazer o login e pegar o token de autorização")
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @Operation(summary = "Recuperar informações do usuário logado")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/me")
    public ResponseEntity<User> me() {
        return ResponseEntity.ok(service.me());
    }

}
