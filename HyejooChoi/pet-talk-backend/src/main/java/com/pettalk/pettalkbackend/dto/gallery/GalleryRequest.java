package com.pettalk.pettalkbackend.dto.gallery;

import lombok.Data;

@Data
public class GalleryRequest {
    String title;
    String content;
    String filename;
    String base64;
    Long writer;
}
