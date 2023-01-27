package edu.henriqueborba.fwcalbumapp.frontend.repositories;

import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationResponse;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth", url = "http://localhost:8080/api")
public interface AuthRepository {

    @PostMapping("/auth")
    AuthenticationResponse login(@RequestBody AuthenticationRequest request);

    @PostMapping("/register")
    AuthenticationResponse register(@RequestBody RegisterRequest registerRequest);

}
