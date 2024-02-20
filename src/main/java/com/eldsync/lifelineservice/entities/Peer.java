package com.eldsync.lifelineservice.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Peer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeer;

    private String linkedAccount;

    private String bioDescription;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @ManyToMany
    private List<Dot> dots;
}