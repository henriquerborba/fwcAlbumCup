package edu.henriqueborba.fwcalbumapp.frontend.repositories;

import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth", url = "http://localhost:8080/api")
public interface AuthRepository {

    @PostMapping("/auth")
    void login(@RequestBody AuthenticationRequest request);

}
