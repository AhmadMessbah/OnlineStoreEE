package com.store.onlinestore.model.entity;

import com.store.onlinestore.model.entity.enums.FileType;

import java.time.LocalDateTime;

public class Attachment {
    private Long id;
    private String filename;
    private FileType fileType;

    private int fileSize;

    private LocalDateTime localDateTime;
    private String description;
}
