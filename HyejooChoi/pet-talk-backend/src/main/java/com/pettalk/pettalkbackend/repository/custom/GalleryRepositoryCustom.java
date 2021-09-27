package com.pettalk.pettalkbackend.repository.custom;

import com.pettalk.pettalkbackend.entity.Gallery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface GalleryRepositoryCustom {
    Page<Object[]> findAllCustom(Pageable pageable);
    List<Gallery> findPopularList();
    Map<String, Object> findByCustom(long galleryNo);
}
