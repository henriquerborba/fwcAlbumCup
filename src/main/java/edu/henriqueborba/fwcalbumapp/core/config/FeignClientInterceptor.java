package edu.henriqueborba.fwcalbumapp.core.config;

import edu.henriqueborba.fwcalbumapp.frontend.repositories.LocalRepository;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class FeignClientInterceptor implements RequestInterceptor {

    private final LocalRepository localRepository;

    public FeignClientInterceptor(LocalRepository localRepository) {
        this.localRepository = localRepository;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if (localRepository.getToken() != null) {
            requestTemplate.header("Authorization", "Bearer " + localRepository.getToken());
        }
    }
}

