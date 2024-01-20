package com.senorientation.backend.guidanceRequest;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.senorientation.backend.formation.Formation;
import com.senorientation.backend.region.Region;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "guidancerequests")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuidanceRequest {
    @Id
    private String id;
    private Formation requestedFormationId;
    private Region requestedRegionId;
    private boolean isAccepted;
    private GuidanceRequestStatus guidanceRequestStatus;
    private Formation recommendedFormationId;
    private String reason;
}
