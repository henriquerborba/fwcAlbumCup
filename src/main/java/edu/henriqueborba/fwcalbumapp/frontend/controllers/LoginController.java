package edu.henriqueborba.fwcalbumapp.frontend.controllers;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.frontend.pages.home.HomeView;

import edu.henriqueborba.fwcalbumapp.frontend.pages.login.LoginView;
import edu.henriqueborba.fwcalbumapp.frontend.pages.register.RegisterView;
import edu.henriqueborba.fwcalbumapp.frontend.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class LoginController {
    private final LoginView view;

    private final RegisterView registerView;

    private final HomeView homeView;

    private final AuthService service;

    public void login(String email, String password) {
        try {
            service.login(email, password);
            homeView.setVisible(true);
            view.dispose();

        } catch (BusinessException e) {
            view.showMessage(e.getMessage());
        } catch (Exception e) {
            view.showMessage("Erro inesperado");
        }
    }
    
    public void redirectToRegister() {
        registerView.setVisible(true);
        view.dispose();
    }

}
