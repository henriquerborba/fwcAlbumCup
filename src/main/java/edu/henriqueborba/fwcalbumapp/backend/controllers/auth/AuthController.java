package edu.henriqueborba.fwcalbumapp.backend.controllers.auth;

import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationResponse;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.RegisterRequest;
import edu.henriqueborba.fwcalbumapp.core.models.User;
import edu.henriqueborba.fwcalbumapp.backend.services.auth.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
@Tag(name = "Auth", description = "Autenticação do usuário")
public class AuthController {

    private final AuthenticationService service;

    @Operation(summary = "Registrar usuário no sistema")
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @Operation(summary = "Fazer o login e pegar o token de autorização")
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @Operation(summary = "Recuperar informações do usuário logado")
    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/me")
    public ResponseEntity<User> me() {
        return ResponseEntity.ok(service.me());
    }

    @Operation(summary = "Refresh token")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/auth/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken() {
        return ResponseEntity.ok(service.refreshToken());
    }
    
    @Operation(summary = "Deslogar usuário e invalidar o token")
    @SecurityRequirement(name = "bearerAuth")
    @PostMapping("/auth/logout")
    public void logout() {
        service.logout();
    }

}
