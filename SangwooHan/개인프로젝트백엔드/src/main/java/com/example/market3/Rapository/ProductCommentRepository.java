package com.example.market3.Rapository;

import com.example.market3.Entity.JpaProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<JpaProductComment,Long> {
}
