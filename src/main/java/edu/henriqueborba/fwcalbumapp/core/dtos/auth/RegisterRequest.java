package edu.henriqueborba.fwcalbumapp.core.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String name;
    @NotBlank(message = "Preencha o campo corretamente")
    @Email
    private String email;
    private String password;
    private String passwordConfirmation;
}
