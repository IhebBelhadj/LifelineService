package org.eldsync.lifelineservice2.services.impl;


import org.eldsync.lifelineservice2.DTOs.req.DotInput;
import org.eldsync.lifelineservice2.entities.Asset;
import org.eldsync.lifelineservice2.entities.Dot;
import org.eldsync.lifelineservice2.entities.Peer;
import org.eldsync.lifelineservice2.enums.EmotionType;
import org.eldsync.lifelineservice2.repositories.AssetRepository;
import org.eldsync.lifelineservice2.repositories.DotRepository;
import org.eldsync.lifelineservice2.repositories.PeerRepository;
import org.eldsync.lifelineservice2.services.DotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DotServiceImpl implements DotService {

    @Autowired
    private DotRepository dotRepository;

    @Autowired
    private PeerRepository peerRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<Dot> searchDots(Long elderId, Date startDate, Date endDate, EmotionType emotionType, List<Long> peerIds) {
        List<Dot> dots = dotRepository.findAll();

        // Filter by elderId
        if (elderId != null) {
            dots = dots.stream().filter(dot -> dot.getElderId().equals(elderId)).collect(Collectors.toList());
        }

        // Filter by startDate
        if (startDate != null) {
            dots = dots.stream().filter(dot -> dot.getEventDate().after(startDate)).collect(Collectors.toList());
        }

        // Filter by endDate
        if (endDate != null) {
            dots = dots.stream().filter(dot -> dot.getEventDate().before(endDate)).collect(Collectors.toList());
        }

        // Filter by emotionType
        if (emotionType != null) {
            dots = dots.stream().filter(dot -> dot.getEmotionType().equals(emotionType)).collect(Collectors.toList());
        }

        // Filter by peerIds
        if (peerIds != null && !peerIds.isEmpty()) {
            dots = dots.stream().filter(dot -> dot.getPeers().stream().anyMatch(peer -> peerIds.contains(peer.getIdPeer()))).collect(Collectors.toList());
        }

        return dots;
    }

    @Override
    public Dot getDotWithId(Long dotId) {
        Optional<Dot> optionalDot = dotRepository.findById(dotId);
        return optionalDot.orElse(null);
    }

    @Override
    public Dot createDot(DotInput dotData) {
        Dot dot = new Dot();
        dot.setElderId(dotData.getElderId());
//        dot.setEventDate(dotData.getEventDate());
        dot.setDotMarkdown(dotData.getDotMarkdown());
        dot.setEmotionType(dotData.getEmotionType());
        dot.setEmotionIntensity(dotData.getEmotionIntensity());

        // Set assets
//        if (dotData.getAssets() != null && !dotData.getAssets().isEmpty()) {
//            List<Asset> assets = dotData.getAssets().stream()
//                    .map(assetId -> assetRepository.findById(assetId).orElse(null))
//                    .filter(Objects::nonNull)
//                    .collect(Collectors.toList());
//            dot.setAssets(assets);
//        }

        // Set peers
//        if (dotData.getPeers() != null && !dotData.getPeers().isEmpty()) {
//            List<Peer> peers = dotData.getPeers().stream()
//                    .map(peerId -> peerRepository.findById(peerId).orElse(null))
//                    .filter(Objects::nonNull)
//                    .collect(Collectors.toList());
//            dot.setPeers(peers);
//        }
//
        return dotRepository.save(dot);
    }

    @Override
    public Dot updateDot(Long idDot, DotInput dotUpdates) {
        Optional<Dot> optionalDot = dotRepository.findById(idDot);
        if (optionalDot.isPresent()) {
            Dot dot = optionalDot.get();
            dot.setElderId(dotUpdates.getElderId());
//            dot.setEventDate(dotUpdates.getEventDate());
            dot.setDotMarkdown(dotUpdates.getDotMarkdown());
            dot.setEmotionType(dotUpdates.getEmotionType());
            dot.setEmotionIntensity(dotUpdates.getEmotionIntensity());

            // Update assets
            if (dotUpdates.getAssets() != null && !dotUpdates.getAssets().isEmpty()) {
                List<Asset> assets = dotUpdates.getAssets().stream()
                        .map(assetId -> assetRepository.findById(assetId).orElse(null))
                        .filter(asset -> asset != null)
                        .collect(Collectors.toList());
                dot.setAssets(assets);
            }

            // Update peers
            if (dotUpdates.getPeers() != null && !dotUpdates.getPeers().isEmpty()) {
                List<Peer> peers = dotUpdates.getPeers().stream()
                        .map(peerId -> peerRepository.findById(peerId).orElse(null))
                        .filter(peer -> peer != null)
                        .collect(Collectors.toList());
                dot.setPeers(peers);
            }

            return dotRepository.save(dot);
        } else {
            // Handle case where dot with given ID is not found
            return null;
        }
    }

    @Override
    public String deleteDot(Long dotId) {
        Optional<Dot> optionalDot = dotRepository.findById(dotId);
        if (optionalDot.isPresent()) {
            dotRepository.deleteById(dotId);
            return "Dot with ID " + dotId + " deleted successfully";
        } else {
            return "Dot with ID " + dotId + " not found";
        }
    }

    @Override
    public Dot appendPeerToDot(Long dotId, Long peerId) {
        Optional<Dot> optionalDot = dotRepository.findById(dotId);
        if (optionalDot.isPresent()) {
            Dot dot = optionalDot.get();
            Optional<Peer> optionalPeer = peerRepository.findById(peerId);
            optionalPeer.ifPresent(peer -> dot.getPeers().add(peer));
            return dotRepository.save(dot);
        } else {
            // Handle case where dot with given ID is not found
            return null;
        }
    }

    @Override
    public Dot appendAssetToDot(Long dotId, Long assetId) {
        Optional<Dot> optionalDot = dotRepository.findById(dotId);
        if (optionalDot.isPresent()) {
            Dot dot = optionalDot.get();
            Optional<Asset> optionalAsset = assetRepository.findById(assetId);
            optionalAsset.ifPresent(asset -> dot.getAssets().add(asset));
            return dotRepository.save(dot);
        } else {
            // Handle case where dot with given ID is not found
            return null;
        }
    }
}