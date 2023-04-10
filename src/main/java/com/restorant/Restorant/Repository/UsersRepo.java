package com.restorant.Restorant.Repository;

import com.restorant.Restorant.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsersRepo extends JpaRepository<User, UUID> {
    boolean existsUserByPhoneNumber(String phoneNumber);

    User findByPhoneNumber(String phoneNumber);
}
