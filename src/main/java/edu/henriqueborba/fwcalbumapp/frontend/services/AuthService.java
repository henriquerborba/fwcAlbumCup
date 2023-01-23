package edu.henriqueborba.fwcalbumapp.frontend.services;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.frontend.repositories.AuthRepository;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService {

    private final AuthRepository repository;


    public void login(String email, String password) {
        var request = new AuthenticationRequest(email, password);
        try {
            repository.login(request);

        } catch (FeignException.Unauthorized e) {
            throw new BusinessException("Usuário ou senha inválidos");
        }
    }
}
