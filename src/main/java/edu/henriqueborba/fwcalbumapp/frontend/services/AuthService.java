package edu.henriqueborba.fwcalbumapp.frontend.services;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.core.advice.Failure;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.frontend.repositories.AuthRepository;
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



    public void login(String email, String password) throws Failure {
        var request = new AuthenticationRequest(email, password);
        try {
            repository.login(request);

        } catch (FeignException.Unauthorized e) {
            throw new Failure("Usuário ou senha inválidos");
        }catch (FeignException.UnprocessableEntity e) {
            throw new Failure(parseValidationErrors(e.contentUTF8()));
        } catch (FeignException.Conflict e) {
            throw new Failure(e.getMessage());
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
}
