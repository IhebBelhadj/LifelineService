package org.eldsync.lifelineservice2.DTOs.req;

import lombok.Data;
import org.eldsync.lifelineservice2.enums.EmotionType;

import java.util.Date;
import java.util.List;

@Data
public class DotInput {
  private Long elderId;
  private String eventDate;
  private String dotMarkdown;
  private EmotionType emotionType;
  private Integer emotionIntensity;
  private List<Long> peers;
  private List<Long> assets;
}