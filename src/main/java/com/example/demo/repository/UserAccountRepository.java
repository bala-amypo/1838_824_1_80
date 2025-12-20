package com.example.demo.repository;

import com.example.demo.entity.UserAccount;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
    public Optional<UserAccount> findByUsername(String username);
}
