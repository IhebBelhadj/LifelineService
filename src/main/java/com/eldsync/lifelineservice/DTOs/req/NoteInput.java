package com.eldsync.lifelineservice.DTOs.req;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class NoteInput {
  private String noteMarkdown;
  private Date reminderTime;
  private List<Long> assets;
}
