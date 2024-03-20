package org.eldsync.lifelineservice2.services;


import org.eldsync.lifelineservice2.DTOs.req.DotInput;
import org.eldsync.lifelineservice2.entities.Dot;
import org.eldsync.lifelineservice2.enums.EmotionType;

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
