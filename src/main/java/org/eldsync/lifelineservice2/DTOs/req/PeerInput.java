package org.eldsync.lifelineservice2.DTOs.req;

import lombok.Data;

import java.util.List;

@Data
public class PeerInput {
  private Long elderId;
  private String linkedAccount;
  private String bioDescription;
  private Long profilePicture;
  private List<Long> notes;
}
