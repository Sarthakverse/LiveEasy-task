package com.sarthak.liveeasytask.service;

import com.sarthak.liveeasytask.dto.ApiResult;
import com.sarthak.liveeasytask.dto.LoadUpdateRequest;
import com.sarthak.liveeasytask.entity.Load;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface loadServiceInterface {
    ResponseEntity<ApiResult> addLoad(Load load);

    ResponseEntity<?> getLoad(UUID shipperId);

    ResponseEntity<?> getLoadsByID(Long loadId);

    ResponseEntity<?> updateLoad(Long loadId, LoadUpdateRequest updatedLoad);

    ResponseEntity<?> deleteLoad(Long loadId);

}
