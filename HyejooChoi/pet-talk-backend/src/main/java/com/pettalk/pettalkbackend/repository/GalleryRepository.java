package com.pettalk.pettalkbackend.repository;

import com.pettalk.pettalkbackend.entity.Gallery;
import com.pettalk.pettalkbackend.repository.custom.GalleryRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GalleryRepository extends JpaRepository<Gallery, Long>, GalleryRepositoryCustom {
}

