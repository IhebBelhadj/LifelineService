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

    private Long elderId;

    private String peerFullName;


    private String linkedAccount;

    private String bioDescription;

    @OneToOne
    private Asset profilePicture;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @ManyToMany(mappedBy = "peers")
    private List<Dot> dots;
}