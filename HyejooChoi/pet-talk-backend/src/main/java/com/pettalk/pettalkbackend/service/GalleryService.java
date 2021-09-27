package com.pettalk.pettalkbackend.service;

import com.pettalk.pettalkbackend.aws.S3Uploader;
import com.pettalk.pettalkbackend.dto.board.BoardRequest;
import com.pettalk.pettalkbackend.dto.gallery.GalleryRequest;
import com.pettalk.pettalkbackend.entity.Board;
import com.pettalk.pettalkbackend.entity.Gallery;
import com.pettalk.pettalkbackend.entity.User;
import com.pettalk.pettalkbackend.repository.GalleryRepository;
import com.pettalk.pettalkbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GalleryService {
    @Autowired
    private GalleryRepository galleryRepository;

    @Autowired
    private UserRepository userRepository;

    private final S3Uploader s3Uploader;

    public Gallery create(GalleryRequest galleryRequest) {
        File file = new File("./" + galleryRequest.getFilename());
        String base64Data = galleryRequest.getBase64().split(",")[1];
        byte[] decoder = Base64.getDecoder().decode(base64Data);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(decoder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgPath = s3Uploader.upload(file, "gallery");

        Gallery gallery = Gallery.builder()
                            .title(galleryRequest.getTitle())
                            .content(galleryRequest.getContent())
                            .writer(galleryRequest.getWriter())
                            .filename(file.getName())
                            .imgPath(imgPath)
                            .build();
        return galleryRepository.save(gallery);
    }

    public Gallery update(long galleryNo, GalleryRequest galleryRequest) {
        Gallery gallery = galleryRepository.findById(galleryNo).orElse(null);
        if (gallery.getFilename() != galleryRequest.getFilename()) {
            File file = new File("./" + galleryRequest.getFilename());
            String base64Data = galleryRequest.getBase64().split(",")[1];
            byte[] decoder = Base64.getDecoder().decode(base64Data);
            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(decoder);
                String imgPath = s3Uploader.upload(file, "gallery");
                gallery.setFilename(galleryRequest.getFilename());
                gallery.setImgPath(imgPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        gallery.setTitle(galleryRequest.getTitle());
        gallery.setContent(galleryRequest.getContent());
        galleryRepository.save(gallery);
        return gallery;
    }

    public Map<String, Object> get(long galleryNo) {
        Map<String, Object> gallery = galleryRepository.findByCustom(galleryNo);
        if (gallery != null) {
            Gallery gallery1 = galleryRepository.findById(galleryNo).orElse(null);
            gallery1.setCount(gallery1.getCount() + 1);
            galleryRepository.save(gallery1);
        }
        return gallery;
    }

    public Page<Object[]> getGalleryList(PageRequest pageRequest) {
        return galleryRepository.findAllCustom(pageRequest);
    }

    public List<Gallery> getPopularList() {
        List<Gallery> galleryList = galleryRepository.findPopularList();
        return galleryList;
    }

    public Boolean delete(long galleryNo) {
        Gallery gallery = galleryRepository.findById(galleryNo).orElse(null);
        galleryRepository.delete(gallery);
        return true;
    }

    public Gallery deleteImage(long galleryNo) {
        Gallery gallery = galleryRepository.findById(galleryNo).orElse(null);
        gallery.setFilename(null);
        gallery.setImgPath(null);
        return galleryRepository.save(gallery);
    }
}
