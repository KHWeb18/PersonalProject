package com.pettalk.pettalkbackend.repository;

import com.pettalk.pettalkbackend.entity.AuthToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthTokenRepository extends JpaRepository<AuthToken, Long> {
}
