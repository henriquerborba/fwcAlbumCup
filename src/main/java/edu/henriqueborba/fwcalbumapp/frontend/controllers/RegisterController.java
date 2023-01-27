package edu.henriqueborba.fwcalbumapp.frontend.controllers;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.frontend.services.AuthService;
import edu.henriqueborba.fwcalbumapp.frontend.views.home.HomeView;
import edu.henriqueborba.fwcalbumapp.frontend.views.register.RegisterView;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final RegisterView view;

    private final AuthService authService;

    private final HomeView homeView;

    public void register(String name, String email, String password, String passwordConfirmation) {
        try {
            authService.register(name, email, password, passwordConfirmation);
            view.showMessage("Usuário cadastrado com sucesso");
            homeView.setVisible(true);
            view.dispose();

        } catch (BusinessException failure) {
            view.showMessage(failure.getMessage());
        } catch (Exception e) {
            view.showMessage("Erro inesperado");
        }
    }

}
