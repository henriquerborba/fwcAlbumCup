package edu.henriqueborba.fwcalbumapp.backend.services.auth;

import edu.henriqueborba.fwcalbumapp.core.advice.BusinessException;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationRequest;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.AuthenticationResponse;
import edu.henriqueborba.fwcalbumapp.core.dtos.auth.RegisterRequest;
import edu.henriqueborba.fwcalbumapp.core.models.Role;
import edu.henriqueborba.fwcalbumapp.core.models.User;
import edu.henriqueborba.fwcalbumapp.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
        private final UserRepository repository;
        private final PasswordEncoder passwordEncoder;
        private final JwtService jwtService;
        private final AuthenticationManager authenticationManager;

        public AuthenticationResponse register(RegisterRequest request) {
                if(repository.existsByEmail(request.getEmail())) {
                        throw new BusinessException("Email já cadastrado");
                }

                var user = User.builder()
                                .email(request.getEmail())
                                .name(request.getName())
                                .password(passwordEncoder.encode(request.getPassword()))
                                .role(Role.USER)
                                .build();

                repository.save(user);

                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public AuthenticationResponse authenticate(AuthenticationRequest request) {
                authenticationManager.authenticate(
                                new UsernamePasswordAuthenticationToken(
                                                request.getEmail(),
                                                request.getPassword()));

                var user = repository.findByEmail(request.getEmail())
                                .orElseThrow();

                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public User me() {
                var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                return repository.findByEmail(user.getEmail()).orElseThrow();
        }

        public AuthenticationResponse refreshToken() {
                var user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
                var jwtToken = jwtService.generateToken(user);
                return AuthenticationResponse.builder()
                                .token(jwtToken)
                                .build();
        }

        public void logout() {
                SecurityContextHolder.clearContext();
        }

}
