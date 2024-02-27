package com.eldsync.lifelineservice.DTOs.req;

import lombok.Data;

@Data
public class AssetInput {
  private String fileName;
  private String fileType;
  private String filePath;
  private String accessLink;
}