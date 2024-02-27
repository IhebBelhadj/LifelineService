package com.eldsync.lifelineservice.repositories;

import com.eldsync.lifelineservice.entities.Dot;
import com.eldsync.lifelineservice.enums.EmotionType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class DotDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Dot> searchDots(Date startDate, Date endDate, EmotionType emotionType, List<Long> peerIds) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Dot> query = criteriaBuilder.createQuery(Dot.class);
        Root<Dot> root = query.from(Dot.class);
        List<Predicate> predicates = new ArrayList<>();

        if (startDate != null && endDate != null) {
            predicates.add(criteriaBuilder.between(root.get("eventDate"), startDate, endDate));
        }
        if (emotionType != null) {
            predicates.add(criteriaBuilder.equal(root.get("emotionType"), emotionType));
        }
        if (peerIds != null && !peerIds.isEmpty()) {
            predicates.add(root.join("peers").get("idPeer").in(peerIds));
        }

        query.select(root).where(predicates.toArray(new Predicate[0]));

        return entityManager.createQuery(query).getResultList();
    }
}
