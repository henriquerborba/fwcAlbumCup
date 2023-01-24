package edu.henriqueborba.fwcalbumapp.core.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    @NotBlank(message = "Campo email é obrigatório")
    @Email(message = "Email inválido")
    private String email;

    @NotBlank(message = "Campo senha é obrigatório")
    private String password;
}
