package edu.henriqueborba.fwcalbumapp.frontend.services;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.RegisterRequest;
import edu.henriqueborba.fwcalbumapp.frontend.repositories.AuthRepository;
import edu.henriqueborba.fwcalbumapp.frontend.repositories.LocalRepository;
import feign.FeignException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@Service
@AllArgsConstructor
public class AuthService {

    private final AuthRepository repository;

    private final LocalRepository localRepository;


    public void login(String email, String password) throws BusinessException {
        var request = new AuthenticationRequest(email, password);
        try {
            var authentcationResponse = repository.login(request);
            localRepository.saveToken(authentcationResponse.getToken());

        } catch (FeignException.Unauthorized e) {
            throw new BusinessException("Usuário ou senha inválidos");
        } catch (FeignException.UnprocessableEntity e) {
            throw new BusinessException(parseValidationErrors(e.contentUTF8()));
        } catch (FeignException.Conflict e) {
            throw new BusinessException(e.getMessage());
        }
    }

    private String parseValidationErrors(String content) {
        JsonObject jsonObject = JsonParser.parseString(content).getAsJsonObject();
        JsonArray errors = jsonObject.getAsJsonArray("errors");

        StringBuilder sb = new StringBuilder();
        for (JsonElement error : errors) {
            sb.append(error.getAsString()).append("\n");
        }

        return sb.toString();
    }

    public void register(String name, String email, String password, String passwordConfirmation) {

        try {
            if(!password.equals(passwordConfirmation)) {
                throw new BusinessException("Senhas não conferem");
            }
            var registerRequest = RegisterRequest.builder()
                    .email(email)
                    .password(password)
                    .passwordConfirmation(passwordConfirmation)
                    .name(name)
                    .build();

            repository.register(registerRequest);
            localRepository.saveToken("token");
        } catch (FeignException.UnprocessableEntity e) {
            throw new BusinessException(parseValidationErrors(e.contentUTF8()));
        } catch (FeignException.Conflict e) {
            throw new BusinessException(e.getMessage());
        }
    }
}
