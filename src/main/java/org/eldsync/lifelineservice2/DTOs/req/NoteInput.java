package org.eldsync.lifelineservice2.DTOs.req;

import lombok.Data;

import java.util.List;

@Data
public class NoteInput {
  private String noteMarkdown;
  private String reminderTime;
  private List<Long> assets;
}
