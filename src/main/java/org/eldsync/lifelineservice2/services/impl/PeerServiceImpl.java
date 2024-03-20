package org.eldsync.lifelineservice2.services.impl;



import org.eldsync.lifelineservice2.DTOs.req.PeerInput;
import org.eldsync.lifelineservice2.entities.Asset;
import org.eldsync.lifelineservice2.entities.Note;
import org.eldsync.lifelineservice2.entities.Peer;
import org.eldsync.lifelineservice2.repositories.AssetRepository;
import org.eldsync.lifelineservice2.repositories.NoteRepository;
import org.eldsync.lifelineservice2.repositories.PeerRepository;

import org.eldsync.lifelineservice2.services.PeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeerServiceImpl implements PeerService {

    @Autowired
    private PeerRepository peerRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Peer getPeerWithId(Long peerId) {
        Optional<Peer> optionalPeer = peerRepository.findById(peerId);
        return optionalPeer.orElse(null);
    }

    @Override
    public List<Peer> getPeersByName(String peerName) {
        return peerRepository.findPeersByPeerFullName(peerName);
    }

    @Override
    public Peer createPeer(PeerInput peerData) {
        Peer peer = new Peer();
        peer.setElderId(peerData.getElderId());
        peer.setLinkedAccount(peerData.getLinkedAccount());
        peer.setBioDescription(peerData.getBioDescription());

        // Set profile picture
        if (peerData.getProfilePicture() != null) {
            Long profilePictureId = peerData.getProfilePicture();
            Optional<Asset> optionalAsset = assetRepository.findById(profilePictureId);
            optionalAsset.ifPresent(peer::setProfilePicture);
        }

        // Set notes
        if (peerData.getNotes() != null && !peerData.getNotes().isEmpty()) {
            List<Note> notes = new ArrayList<>();
            for (Long noteId : peerData.getNotes()) {
                Optional<Note> optionalNote = noteRepository.findById(noteId);
                optionalNote.ifPresent(notes::add);
            }
            peer.setNotes(notes);
        }

        return peerRepository.save(peer);
    }

    @Override
    public Peer updatePeer(Long peerId, PeerInput peerUpdates) {
        Optional<Peer> optionalPeer = peerRepository.findById(peerId);
        if (optionalPeer.isPresent()) {
            Peer peer = optionalPeer.get();
            peer.setElderId(peerUpdates.getElderId());
            peer.setLinkedAccount(peerUpdates.getLinkedAccount());
            peer.setBioDescription(peerUpdates.getBioDescription());

            // Update profile picture
            if (peerUpdates.getProfilePicture() != null) {
                Long profilePictureId = peerUpdates.getProfilePicture();
                Optional<Asset> optionalAsset = assetRepository.findById(profilePictureId);
                optionalAsset.ifPresent(peer::setProfilePicture);
            }

            // Update notes
            if (peerUpdates.getNotes() != null && !peerUpdates.getNotes().isEmpty()) {
                List<Note> notes = new ArrayList<>();
                for (Long noteId : peerUpdates.getNotes()) {
                    Optional<Note> optionalNote = noteRepository.findById(noteId);
                    optionalNote.ifPresent(notes::add);
                }
                peer.setNotes(notes);
            }

            return peerRepository.save(peer);
        } else {
            // Handle case where peer with given ID is not found
            return null;
        }
    }

    @Override
    public String deletePeer(Long peerId) {
        Optional<Peer> optionalPeer = peerRepository.findById(peerId);
        if (optionalPeer.isPresent()) {
            peerRepository.deleteById(peerId);
            return "Peer with ID " + peerId + " deleted successfully";
        } else {
            return "Peer with ID " + peerId + " not found";
        }
    }
}
