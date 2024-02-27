package com.eldsync.lifelineservice.entities;

import com.eldsync.lifelineservice.enums.EmotionType;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
public class Dot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDot;

    private Long elderId;

    private Date eventDate;

    private String dotMarkdown;

    @Enumerated(EnumType.STRING)
    private EmotionType emotionType;

    private Integer emotionIntensity;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asset> assets;

    @ManyToMany()
    private List<Peer> peers;

}
