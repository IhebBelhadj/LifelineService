package org.eldsync.lifelineservice2.DTOs.req;

import lombok.Data;

@Data
public class AssetInput {
  private String fileName;
  private String fileType;
  private String filePath;
  private String accessLink;
}