package com.pensareluis.Holamundo.repository;

import com.pensareluis.Holamundo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/03/27
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<Account,Serializable>{
    Optional<Account> findFirstByUsername(String username);
}
