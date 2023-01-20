package edu.henriqueborba.fwcalbumapp.repository;

import edu.henriqueborba.fwcalbumapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
