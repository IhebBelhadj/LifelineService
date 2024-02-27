package com.eldsync.lifelineservice.services;

import com.eldsync.lifelineservice.DTOs.req.DotInput;
import com.eldsync.lifelineservice.entities.Dot;
import com.eldsync.lifelineservice.enums.EmotionType;

import java.util.Date;
import java.util.List;

public interface DotService {
    List<Dot> searchDots(
        Long elderId,
        Date startDate,
        Date endDate,
        EmotionType emotionType,
        List<Long> peerIds
    );
    Dot getDotWithId(Long dotId);
    Dot createDot(DotInput dotData);
    Dot updateDot(Long idDot ,DotInput dotUpdates);
    String deleteDot(Long dotId);
    Dot appendPeerToDot(Long dotId, Long peerId);
    Dot appendAssetToDot(Long dotId, Long assetId);
}
