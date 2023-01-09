package edu.henriqueborba.fwcalbumapp.controllers.auth;

import edu.henriqueborba.fwcalbumapp.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.dtos.auth.AuthenticationResponse;
import edu.henriqueborba.fwcalbumapp.dtos.auth.RegisterRequest;
import edu.henriqueborba.fwcalbumapp.models.User;
import edu.henriqueborba.fwcalbumapp.services.auth.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Validated @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @SecurityRequirement(name = "bearerAuth")
    @GetMapping("/me")
    public ResponseEntity<User> me() {
        return ResponseEntity.ok(service.me());
    }

}
