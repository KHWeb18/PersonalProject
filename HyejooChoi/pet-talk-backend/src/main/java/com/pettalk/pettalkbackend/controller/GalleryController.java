package com.pettalk.pettalkbackend.controller;

import com.pettalk.pettalkbackend.dto.BoardType;
import com.pettalk.pettalkbackend.dto.PetTalkResponse;
import com.pettalk.pettalkbackend.dto.gallery.GalleryRequest;
import com.pettalk.pettalkbackend.entity.Comment;
import com.pettalk.pettalkbackend.entity.Gallery;
import com.pettalk.pettalkbackend.service.CommentService;
import com.pettalk.pettalkbackend.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/gallery")
public class GalleryController {
    @Autowired
    private GalleryService galleryService;

    @Autowired
    private CommentService commentService;


    /**
     * 갤러리 게시글 등록
     * @param galleryRequest
     * @return
     */
    @PostMapping("/create")
    public PetTalkResponse<Gallery> create(@RequestBody GalleryRequest galleryRequest) {
        PetTalkResponse<Gallery> response = new PetTalkResponse<>();
        Gallery gallery = galleryService.create(galleryRequest);
        response.setData(gallery);
        return response;
    }

    /**
     * 갤러리 게시글 수정
     * @param galleryNo
     * @param galleryRequest
     * @return
     */
    @PostMapping("/update/{galleryNo}")
    public PetTalkResponse<Gallery> update(@PathVariable long galleryNo, @RequestBody GalleryRequest galleryRequest) {
        PetTalkResponse<Gallery> response = new PetTalkResponse<>();
        Gallery gallery = galleryService.update(galleryNo, galleryRequest);
        response.setData(gallery);
        return response;
    }

    /**
     * 갤러리 게시글 조회
     * @param galleryNo
     * @return
     */
    @GetMapping("/{galleryNo}")
    public PetTalkResponse<Map<String, Object>> getGallery(@PathVariable long galleryNo) {
        PetTalkResponse<Map<String, Object>> response = new PetTalkResponse<>();
        Map<String, Object> gallery = galleryService.get(galleryNo);
        List<Object[]> comment = commentService.getComment(BoardType.GALLERY, galleryNo);
        Map<String, Object> map = new HashMap<>();
        map.put("gallery", gallery);
        map.put("comment", comment);
        response.setData(map);
        return response;
    }

    /**
     * 갤러리 게시글 목록 조회 (페이징)
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/list/{page}/{size}")
    public PetTalkResponse<Page<Object[]>> getGalleryList(@PathVariable Integer page, @PathVariable Integer size) {
        PetTalkResponse<Page<Object[]>> response = new PetTalkResponse<>();
        Page<Object[]> galleryList = galleryService.getGalleryList(PageRequest.of(page - 1, size, Sort.Direction.DESC, "id"));
        response.setData(galleryList);
        return response;
    }

    /**
     * 갤러리 인기 게시글 조회 (10개)
     * @return
     */
    @GetMapping("/popular")
    public PetTalkResponse<List<Gallery>> getPopularList() {
        PetTalkResponse<List<Gallery>> response = new PetTalkResponse<>();
        List<Gallery> galleryList = galleryService.getPopularList();
        response.setData(galleryList);
        return response;
    }

    /**
     * 갤러리 게시글 삭제
     * @param galleryNo
     * @return
     */
    @DeleteMapping("/delete/{galleryNo}")
    public PetTalkResponse<Boolean> delete(@PathVariable long galleryNo) {
        PetTalkResponse<Boolean> response = new PetTalkResponse<>();
        Boolean boo = galleryService.delete(galleryNo);
        response.setData(boo);
        return response;
    }

    @DeleteMapping("/delete/image/{galleryNo}")
    public PetTalkResponse<Gallery> deleteImage(@PathVariable long galleryNo) {
        PetTalkResponse<Gallery> response = new PetTalkResponse<>();
        Gallery gallery = galleryService.deleteImage(galleryNo);
        response.setData(gallery);
        return response;
    }
}
