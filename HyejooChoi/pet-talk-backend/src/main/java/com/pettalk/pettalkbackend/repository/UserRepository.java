package com.pettalk.pettalkbackend.repository;

import com.pettalk.pettalkbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(String userId);

    public Boolean existsByUserId(String userId);

    public Boolean existsByEmail(String email);
}
