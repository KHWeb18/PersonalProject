package com.example.market3.Rapository;

import com.example.market3.Entity.JpaSkycowComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface SkycowCommentRepository extends JpaRepository<JpaSkycowComment,Long> {


}
