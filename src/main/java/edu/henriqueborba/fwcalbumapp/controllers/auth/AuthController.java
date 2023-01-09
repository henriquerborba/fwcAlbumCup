package edu.henriqueborba.fwcalbumapp.controllers.auth;

import edu.henriqueborba.fwcalbumapp.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.dtos.auth.AuthenticationResponse;
import edu.henriqueborba.fwcalbumapp.dtos.auth.RegisterRequest;
import edu.henriqueborba.fwcalbumapp.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    };

    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    };

}
