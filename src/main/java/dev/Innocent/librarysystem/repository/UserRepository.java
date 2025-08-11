package dev.Innocent.librarysystem.repository;

import dev.Innocent.librarysystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    public User findByEmail(String email);
}
