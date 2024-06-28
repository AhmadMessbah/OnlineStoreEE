package com.store.onlinestore.model.entity;

import com.store.onlinestore.model.entity.enums.FileType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "attachmentEntity")
@Table(name="attachment_tbl")

public class Attachment {
    @Id
    @SequenceGenerator(name = "attachmentSeq", sequenceName = "attachment_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attachmentSeq")
    private Long id;
    private String filename;
    private FileType fileType;

    private int fileSize;

    private LocalDateTime localDateTime;
    private String description;
}
