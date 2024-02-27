package com.eldsync.lifelineservice.DTOs.req;

import com.eldsync.lifelineservice.enums.EmotionType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DotInput {
  private Long elderId;
  private Date eventDate;
  private String dotMarkdown;
  private EmotionType emotionType;
  private Integer emotionIntensity;
  private List<Long> peers;
  private List<Long> assets;
}