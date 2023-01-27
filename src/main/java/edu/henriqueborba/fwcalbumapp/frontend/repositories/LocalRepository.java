package edu.henriqueborba.fwcalbumapp.frontend.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class LocalRepository {

    private String token;

    public void saveToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
