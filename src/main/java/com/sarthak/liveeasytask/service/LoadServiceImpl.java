package com.sarthak.liveeasytask.service;

import com.sarthak.liveeasytask.dto.ApiResult;
import com.sarthak.liveeasytask.dto.LoadUpdateRequest;
import com.sarthak.liveeasytask.entity.Load;
import com.sarthak.liveeasytask.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoadServiceImpl implements loadServiceInterface {

    private final LoadRepository loadRepository;

    public ResponseEntity<ApiResult> addLoad(Load load) {
        try {
            log.info("load entity fetched successfully");

            loadRepository.save(load);

            log.info("Loads details added successfully into database");

            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("loads details added successfully");

            return new ResponseEntity<>(apiResult, HttpStatus.CREATED);


        } catch (Exception e) {
            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Error in adding loads details");
            return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<?> getLoad(UUID shipperId) {
        try {
            List<Load> loads = loadRepository.findAllByShipperId(shipperId);

            if (loads == null || loads.isEmpty()) {
                ApiResult apiResult = new ApiResult();
                apiResult.setMessage("No loads found for the given shipperId");
                return new ResponseEntity<>(apiResult, HttpStatus.NOT_FOUND);
            }

            log.info("Loads details fetched successfully from database by shipperId");

            return new ResponseEntity<>(loads, HttpStatus.OK);
        } catch (Exception e) {
            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Error in fetching loads details by shipperId");
            return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    public ResponseEntity<?> getLoadsByID(Long loadId) {
        try {
            Load load = loadRepository.findById(loadId).orElse(null);

            if (load == null) {
                ApiResult apiResult = new ApiResult();
                apiResult.setMessage("No loads found for the given loadId");
                return new ResponseEntity<>(apiResult, HttpStatus.NOT_FOUND);
            }

            log.info("Loads details fetched successfully from database by loadId");

            return new ResponseEntity<>(load, HttpStatus.OK);
        } catch (Exception e) {
            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Error in fetching loads details by loadId");
            return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    public ResponseEntity<?> updateLoad(Long loadId, LoadUpdateRequest updatedLoad) {
        try {
            Load existingLoad = loadRepository.findById(loadId).orElse(null);

            if (existingLoad == null) {
                ApiResult apiResult = new ApiResult();
                apiResult.setMessage("No load found for the given loadId");
                return new ResponseEntity<>(apiResult, HttpStatus.NOT_FOUND);
            }

            existingLoad.setLoadingPoint(updatedLoad.getLoadingPoint());
            existingLoad.setUnloadingPoint(updatedLoad.getUnloadingPoint());
            existingLoad.setProductType(updatedLoad.getProductType());
            existingLoad.setTruckType(updatedLoad.getTruckType());
            existingLoad.setNoOfTrucks(updatedLoad.getNoOfTrucks());
            existingLoad.setWeight(updatedLoad.getWeight());
            existingLoad.setComment(updatedLoad.getComment());
            existingLoad.setDate(updatedLoad.getDate());

            loadRepository.save(existingLoad);

            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Load details updated successfully");
            return new ResponseEntity<>(apiResult, HttpStatus.OK);
        } catch (Exception e) {
            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Error updating load details");
            return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<?> deleteLoad(Long loadId) {
        try {
            Load existingLoad = loadRepository.findById(loadId).orElse(null);

            if (existingLoad == null) {
                ApiResult apiResult = new ApiResult();
                apiResult.setMessage("No load found for the given loadId");
                return new ResponseEntity<>(apiResult, HttpStatus.NOT_FOUND);
            }

            loadRepository.deleteById(loadId);

            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Load details deleted successfully");
            return new ResponseEntity<>(apiResult, HttpStatus.OK);
        } catch (Exception e) {
            ApiResult apiResult = new ApiResult();
            apiResult.setMessage("Error deleting load details");
            return new ResponseEntity<>(apiResult, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
