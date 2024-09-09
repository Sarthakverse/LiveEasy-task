package com.sarthak.liveeasytask.controller;

import com.sarthak.liveeasytask.dto.ApiResult;
import com.sarthak.liveeasytask.dto.LoadUpdateRequest;
import com.sarthak.liveeasytask.entity.Load;
import com.sarthak.liveeasytask.service.LoadServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/load")
@Slf4j
@RequiredArgsConstructor
@Tag(name = "Load API", description = "Operations related to load management")
public class LoadController {

    private final LoadServiceImpl loadService;

    @Operation(summary = "Create a new load",
            description = "Creates a new load and saves it to the database",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Load created successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResult.class))),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PostMapping
    public ResponseEntity<ApiResult> createLoad(@Valid @RequestBody Load load) {
        log.info("Load entity fetched successfully");
        return loadService.addLoad(load);
    }

    @Operation(summary = "Get loads by Shipper ID",
            description = "Fetch loads based on the provided shipper ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Load(s) retrieved successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Load.class))),
                    @ApiResponse(responseCode = "404", description = "No loads found for the given shipper ID"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping
    public ResponseEntity<?> getLoad(@RequestParam("shipperId") UUID shipperId) {
        log.info("Loads details fetched successfully from database by shipperId");
        return loadService.getLoad(shipperId);
    }

    @Operation(summary = "Get load by Load ID",
            description = "Fetch load details by the provided load ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Load retrieved successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Load.class))),
                    @ApiResponse(responseCode = "404", description = "No load found for the given load ID"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @GetMapping("/{loadId}")
    public ResponseEntity<?> getLoadsByLoadId(@PathVariable Long loadId) {
        log.info("Loads details fetched successfully from database by loadId");
        return loadService.getLoadsByID(loadId);
    }

    @Operation(summary = "Update load details",
            description = "Update load details by the provided load ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Load updated successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResult.class))),
                    @ApiResponse(responseCode = "404", description = "Load not found for the given ID"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @PutMapping("/{loadId}")
    public ResponseEntity<?> updateTheLoad(@PathVariable Long loadId,
                                           @RequestBody @Valid LoadUpdateRequest updatedLoad) {
        log.info("Load entity to be updated has been fetched successfully");
        return loadService.updateLoad(loadId, updatedLoad);
    }

    @Operation(summary = "Delete load by Load ID",
            description = "Deletes the load by the provided load ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Load deleted successfully",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ApiResult.class))),
                    @ApiResponse(responseCode = "404", description = "Load not found for the given ID"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")
            })
    @DeleteMapping("/{loadId}")
    public ResponseEntity<?> deleteLoad(@PathVariable Long loadId) {
        log.info("Load entity to be deleted has been fetched successfully");
        return loadService.deleteLoad(loadId);
    }
}
