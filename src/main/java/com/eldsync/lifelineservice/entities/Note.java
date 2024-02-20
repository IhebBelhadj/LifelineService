package com.eldsync.lifelineservice.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noteId;

    private String noteMarkdown;

    private Date createdAt;

    private Date updatedAt;

    private Date reminderTime;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asset> assets;
}